package DoItCodingTest.PeriodSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 나머지 합 구하기 / 골드 3 / 시간 제한 1초
 * */
public class B_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] sumArr = new long[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++){
            sumArr[i] = sumArr[i-1] + Integer.parseInt(st.nextToken());
        }


    }
}
