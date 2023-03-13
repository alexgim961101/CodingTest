package dp;

import java.io.*;

public class B_10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dy = new int[21];
        dy[0] = 0;
        dy[1] = 1;
        for(int i = 2; i <= 20; i++){
            dy[i] = dy[i-1] + dy[i-2];
        }

        int n = Integer.parseInt(br.readLine());
        bw.append(dy[n] + "");
        bw.flush();
        bw.close();
    }
}
