package beakjoon.simulation;

import java.io.*;
import java.util.*;


/**
 * 필요 기능
 *
 * 1). 지도의 숫자가 0이면 주사위 숫자를 지도에 복사, 0이 아니면 지도 숫자를 주사위에 복사
 * - 둘 다 0일 경우, pass
 * 2). 주사위 이동
 * - 주사위가 지도를 나갈 경우 무시
 * 3). 주사위 윗면 출력
 * */
public class B_14499 {
    static int N, M, r, c, k;
    static int[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 명령
        st = new StringTokenizer(br.readLine());
        Dice dice = new Dice();
        for(int i = 0; i < k; i++) {
            int comm = Integer.parseInt(st.nextToken());

            // 현재 지도와 주사위 비교해서 값 교환
            changNum(dice);

            // 주사위 이동
            if(!moveCheck(comm)) continue;
            dice.move(comm);

            // 주사위 윗면 출력
            System.out.println(dice.top);
        }

    }

    public static void changNum(Dice dice) {
        if(dice.down == 0 && board[r][c] == 0) return;

        if(board[r][c] == 0) board[r][c] = dice.down;
        else {
            dice.down = board[r][c];
            board[r][c] = 0;
        }
    }

    public static boolean moveCheck(int comm) {
        comm--;

        int nx = c + dx[comm];
        int ny = r + dy[comm];

        if(nx < 0 || nx >= M || ny < 0 || ny >= N) return false;
        else return true;
    }


    static class Dice {
        int top, down;
        int right, left, front, back;


        public Dice() {
        }

        public Dice(int top, int down, int right, int left, int front, int back) {
            this.top = top;
            this.down = down;
            this.right = right;
            this.left = left;
            this.front = front;
            this.back = back;
        }

        public void move(int comm) {
            comm--;
            r = r + dy[comm];
            c = c + dx[comm];
            switch (comm) {
                case 0:
                    right(comm);
                    break;
                case 1:
                    left(comm);
                    break;
                case 2:
                    down(comm);
                    break;
                default:
                    up(comm);
            }
        }


        private void left(int comm) {
            int tmp = this.down;
            this.down = this.left;
            this.left = this.top;
            this.top = this.right;
            this.right = tmp;
        }

        private void right(int comm) {
            int tmp = this.down;
            this.down = this.right;
            this.right = this.top;
            this.top = this.left;
            this.left = tmp;
        }

        private void down(int comm) {
            int tmp = this.down;
            this.down = this.front;
            this.front = this.top;
            this.top = this.back;
            this.back = tmp;
        }

        private void up(int comm) {
            int tmp = this.down;
            this.down = this.back;
            this.back = this.top;
            this.top = this.front;
            this.front = tmp;
        }
    }
}
