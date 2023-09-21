package inflearn.extream.dp;

import java.io.*;
import java.util.*;

public class B_2073 {
    static int d, p;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        d = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        dp = new int[d + 1];

        for(int i = 0; i < p; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for(int j = d; j >= l; j--) {
                if(j == l) {
                    dp[j] = Math.max(dp[j], c);
                    break;
                }
                if(dp[j - l] != 0) {
                    int value = Math.min(dp[j - l], c);
                    dp[j] = Math.max(dp[j], value);
                }
            }
        }

        System.out.println(dp[d]);
    }
}
