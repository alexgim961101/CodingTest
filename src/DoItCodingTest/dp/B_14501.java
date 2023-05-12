package DoItCodingTest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 3 / 퇴사
 * 해결 방법
 * dy[i] = i일 까지 얻을 수 있는 최대 수익
 * dy[i] =
 * */
public class B_14501 {
    static int N;
    static int[] T;
    static int[] P;
    static int[] dy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        T = new int[N+1];
        P = new int[N+1];
        dy = new int[N+2];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            T[i] = num1;
            P[i] = num2;
        }

        for(int i = N; i > 0; i--){
            int next = i + T[i];

            if(next > N + 1) dy[i] = dy[i + 1];
            else {
                dy[i] = Math.max(dy[i+1], dy[next] + P[i]);
            }
        }

        System.out.println(dy[1]);
    }
}
