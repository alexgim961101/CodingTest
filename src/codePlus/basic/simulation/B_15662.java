package codePlus.basic.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 골드 5 / 톱니바퀴2
 * */
public class B_15662 {
    static int T; // 톱니버퀴 수
    static int[][] arr; // 톱니바퀴의 상태를 저장하는 배열
    static int k; // 회전 횟수
    static int[][] comm; // 회전 명령 (톱니바퀴의 번호, 방향)
    static int[] dirArr; // 회전 방향 조사를 위한 배열
    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        T = Integer.parseInt(br.readLine());
        arr = new int[T][8];
        for(int i = 0; i < T; i++){
            String str = br.readLine();
            for(int j = 0; j < 8; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        k = Integer.parseInt(br.readLine());
        comm = new int[k][2];
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine(), " ");
            comm[i][0] = Integer.parseInt(st.nextToken()) - 1;
            comm[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < k; i++) {
            // 2. 특정 톱니바퀴를 회전시켰을 때, 주변 톱니바퀴 회전 여부 검사
            dirArr = new int[T];
            int point = comm[i][0];
            int dir = comm[i][1];
            dirArr[point] = dir;
            // 2-1. 왼쪽에 있는 톱니바퀴 검사
            for(int j = point; j > 0; j--){
                if(arr[j][6] != arr[j-1][2]) {
                    dirArr[j-1] = -dirArr[j];
                } else break;
            }
            // 2-2. 오른쪽에 있는 톱니바퀴 검사
            for(int j = point; j < T-1; j++){
                if(arr[j][2] != arr[j+1][6]){
                    dirArr[j+1] = -dirArr[j];
                } else break;
            }

            // 3. 회전 검사를 조사한 토대로 톱니바퀴 회전
            for(int j = 0; j < T; j++){
                if(dirArr[j] == 1) { // 시계방향 회전
                    int tmp = arr[j][7];
                    for(int x = 7; x >= 1; x--){
                        arr[j][x] = arr[j][x-1];
                    }
                    arr[j][0] = tmp;
                } else if (dirArr[j] == -1){  // 반시계방향 회전
                    int tmp = arr[j][0];
                    for(int x = 0; x < 7; x++){
                        arr[j][x] = arr[j][x+1];
                    }
                    arr[j][7] = tmp;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < T; i++){
            if(arr[i][0] == 1) count++;
        }
        System.out.print(count);
    }
}
