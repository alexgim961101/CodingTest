package codePlus.basic.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1로 만들기 / (실버 3) / 시간 제한 : 0.15초 / N <= 1000000
 * https://www.acmicpc.net/problem/1463
 * dy[n] = 1을 만들수 있는 연산의 최소 횟수
 * dy[n] = Min(dy[n/3], dy[n/2], dy[n-1]) + 1
 * 가장 작은 크기의 문제 dy[1] = 1;
 * */
public class B_1463 {
    int[] dy = new int[1000001];
    int rec(int n) {
        if(n == 1) return 0;
        if(dy[n] > 0) return dy[n];

        dy[n] = rec(n-1) + 1;  // 아래에서 비교해야 하기 때문에 항상 가능한 조건부터 처리하는게 좋음

        if(n % 2 == 0) {
            int tmp = rec(n/2) + 1;
            dy[n] = Math.min(tmp, dy[n]);
        }
        
        if(n % 3 == 0) {
            int tmp = rec(n/3) + 1;
            dy[n] = Math.min(tmp, dy[n]);
        }

        return dy[n];
    }

    int iter(int n) {
        dy[1] = 0;

        for(int i = 2; i <= n; i++){
            dy[i] = dy[i-1] + 1;

            if(i % 2 == 0) {
                int tmp = dy[i/2] + 1;
                dy[i] = Math.min(dy[i], tmp);
            }

            if(i % 3 == 0) {
                int tmp = dy[i/3] + 1;
                dy[i] = Math.min(dy[i], tmp);
            }
        }

        return dy[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        B_1463 b = new B_1463();

        System.out.println(b.iter(n));
    }
}
