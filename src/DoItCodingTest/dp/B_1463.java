package DoItCodingTest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버 3 / 1로 만들기
 * 해결 방법
 * dy[i] : i -> 1로 만드는데 사용하는 최소 연산 수
 * i % 3 == 0  -> dy[i] = dy[i / 3] + 1;
 * i % 2 == 0  -> dy[i] = dy[i / 2] + 1;
 * dy[i] = dy[i-1] + 1;
 * */
public class B_1463 {
    static int N;
    static int[] dy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dy = new int[N+1];
        for(int i = 2; i <= N; i++){
            dy[i] = dy[i-1] + 1;
            if(i % 2 == 0) dy[i] = Math.min(dy[i], dy[i / 2] + 1);
            if(i % 3 == 0) dy[i] = Math.min(dy[i], dy[i / 3] + 1);
        }

        System.out.println(dy[N]);
    }
}
