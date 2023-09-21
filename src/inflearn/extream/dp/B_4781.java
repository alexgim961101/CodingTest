package inflearn.extream.dp;

import java.io.*;
import java.util.*;

// 문제 요약
// - 가지고 있는 돈으로 최대한 높은 칼로리 만들기
public class B_4781 {

    static int n, m;
    static int[] dy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);

            if(n == 0 && m == 0) break;
            dy = new int[m+1];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int p = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);

                for(int j = p; j <= m; j++) {
                    dy[j] = Math.max(dy[j - p] + c, dy[j]);
                }
            }
            sb.append(dy[m]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
