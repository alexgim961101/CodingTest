package DoItCodingTest.PeriodSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간 합 구하기 2 / 실버 1 / 시간 제한 1초
 * */
public class B_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N+1][N+1];
        int[][] sumBoard = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                sumBoard[i][j] = board[i][j] + sumBoard[i-1][j] + sumBoard[i][j-1] - sumBoard[i-1][j-1];
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = sumBoard[x2][y2] - sumBoard[x2][y1-1] - sumBoard[x1-1][y2] + sumBoard[x1-1][y1-1];
            System.out.println(sum);
        }
    }
}
