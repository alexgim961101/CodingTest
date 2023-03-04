package codePlus.basic.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14503 {
    static int N, M;  // 가로, 세로
    static int r, c, dir;  // y, x, 방향
    static int[][] board;
    // 0 : 북
    // 1 : 동
    // 2 : 남
    // 3 : 서
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void output() {
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] == 2) count++;
            }
        }
        System.out.print(count);
    }

    public static void process() {
        while (true) {
            if(board[r][c] == 0) board[r][c] = 2;
            if(board[r-1][c] != 0 && board[r][c+1] != 0 && board[r+1][c] != 0 && board[r][c-1] != 0){
                if(board[r-dy[dir]][c-dx[dir]] == 1) break;
                else {
                    r = r - dy[dir];
                    c = c - dx[dir];
                }
            } else {
                dir = (dir - 1 + 4) % 4;
                if(board[r + dy[dir]][c + dy[dir]] == 0) {
                    r = r + dy[dir];
                    c = c + dx[dir];
                }
            }
        }
    }
}
