package bakingdog.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 방 배정 / 브론즈 2
 *
 * 해결 방법
 * 1). int[][] arr = new int[2][6]의 배열 생성 -> 성별 : 남,여 / 학년 : 6학년 이끼 때문에
 * 2). 입력을 받으면서 2차원 배열 채우기
 * 3). 반복문을 돌면서 count += (arr[i][j] / V) + (arr[i][j] % V != 0 ? 1 : 0) 식 사용
 * 4). count return;
 * */
public class B_13300 {
    static int N, V, cnt;
    static int[][] arr = new int[2][7];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        cnt = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            arr[gender][grade]++;
        }

        for(int i = 0; i < 2; i++){
            for(int j = 1; j <= 6; j++) {
                cnt += (arr[i][j] / V) + (arr[i][j] % V != 0 ? 1 : 0);
            }
        }

        System.out.println(cnt);
    }
}
