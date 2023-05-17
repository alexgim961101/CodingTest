package beakjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 해결 로직
 * 1). 컨베이어 벨트를 회전시키는 로직 필요 (cycle())
 * 2). 로봇을 한칸 움직이는 로직 필요 (move())
 * 3). 몇 번째 단계인지 체크해줄 level 변수 필요
 * */
public class B_20055 {
    static int N, K, level;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        level = 0;

        arr = new int[2 * N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2 * N; i++){
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;
        }


        while(check()) {
            level++;
            around();
            move();
            if(arr[0] > 0) {
                arr[0]--;
                visited[0] = true;
            }
        }

        System.out.print(level);
    }

    private static boolean check() {
        int cnt = 0;
        for(int i = 0; i < 2 * N; i++) {
            if(arr[i] == 0) cnt++;
        }
        return cnt >= K ? false : true;
    }

    private static void move() {
        for(int i = N - 1; i > 0; i--) {
            if(visited[i - 1] && arr[i] >= 1 && !visited[i]) {
                visited[i] = true;
                visited[i - 1] = false;
                arr[i]--;
            }
        }
        visited[N-1] = false;
    }

    private static void around() {
        int tmp = arr[2 * N - 1];
        for(int i = 2 * N - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = tmp;

        for(int i = N - 1; i > 0; i--){
            visited[i] = visited[i - 1];
        }
        visited[0] = false;
        visited[N - 1] = false;
    }


}
