package DoItCodingTest.PeriodSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 나머지 합 구하기 / 골드 3 / 시간 제한 1초
 * (sumArr[i] - sumArr[i-1]) % M == 0        => 특정 구간의 합의 나머지는 0이다
 * => sumArr[i] % M - sumArr[i-1] % M == 0   => 위의 식을 길게 풀어봄
 * => sumArr[i] % M == sumArr[i-1] % M    식이 핵십
 *
 * 조합 식 : nCr = n-1Cr-1 + n-1Cr
 * */
public class B_10986 {

    static int[][] combiArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] remainder = new long[M];

        long count = 0;

        // 합의 나머지 배열 구허기
        int[] sumArr = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++){
            sumArr[i] = (sumArr[i-1] + Integer.parseInt(st.nextToken())) % M;
            if(sumArr[i] == 0) count++;
            remainder[sumArr[i]]++;
        }

        // combiArr = new int[N+1][N+1];
        for(int i = 0; i < M; i++){
            if(remainder[i] > 1){
//                count += combi(remainder[i], 2);     // 구간을 잡아야 하기 때문에 r == 2 이다.
                count += (remainder[i] * (remainder[i]-1)) / 2;
            }
        }
        System.out.print(count);
    }

    // 조합 구현
//    public static int combi(int n, int r) {
//        if(combiArr[n][r] > 0) return combiArr[n][r];
//        if(n == r || r == 0) return combiArr[n][r] = 1;
//        return combiArr[n][r] = combi(n-1, r-1) + combi(n-1, r);
//    }
}
