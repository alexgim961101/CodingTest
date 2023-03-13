package dp;

import java.io.*;

/**
 * 백준 / 실버 3 / 파보나치 함수
 * 문제 요약
 * n에 대하여 파보나치 연산을 했을 때, 0과 1의 갯수를 각각 출력
 *
 * 점화식 2개
 * n일 때의 0의 갯수 : dy[n][0] = dy[n-1][0] + dy[n-2][0]
 * n일 때의 1의 갯수 : dy[n][1] = dy[n-1][1] + dy[n-2][1]
 * */
public class B_1003 {
    static int t;
    static int[][] dy = new int[41][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());

        dy[0][0] = 1;
        dy[1][0] = 0;
        dy[0][1] = 0;
        dy[1][1] = 1;

        for(int i = 2; i <= 40; i++){
            dy[i][0] = dy[i-1][0] + dy[i-2][0];
            dy[i][1] = dy[i-1][1] + dy[i-2][1];
        }

        for(int i = 0; i < t; i++){
            int val = Integer.parseInt(br.readLine());
            bw.append(dy[val][0] + " " + dy[val][1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
