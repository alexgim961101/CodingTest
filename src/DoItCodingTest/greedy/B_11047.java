package DoItCodingTest.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 / 실버 4 / 동전 0
 * */
public class B_11047 {
    static int N, K;
    static int[] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int idx = N-1;
        while (K != 0) {
            if(arr[idx] <= K) {
                answer += (K / arr[idx]);
                K = K % arr[idx];
            }
            idx--;
        }

        System.out.println(answer);
    }
}
