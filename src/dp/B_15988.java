package dp;

import java.io.*;

/**
 * 백준 / 실버 2 / 1, 2, 3 더하기 3
 * 점화식
 * dy[i] : dy[i-1] + dy[i-2] + dy[i-3]
 * */
public class B_15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        long[] dy = new long[1000001];
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;
        for(int i = 4; i <= 1000000; i++){
            dy[i] = (dy[i-1] + dy[i-2] + dy[i-3]) % 1000000009;
        }
        for(int i = 0; i < t; i++){
            int val = Integer.parseInt(br.readLine());
            bw.append(dy[val] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
