package codePlus.basic.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주사위 굴리기 / 골드 4 / 시간제한 2초 / 메모리 제한 512MB
 * 해결 순서
 * 1). 주사위 전개도를 1차원 배열로 만들어 저장
 * 2). 각 움직임 별로 함수를 만듬 (동서남북)
 * 3). 주사위를 움직였을 때, 지도 칸의 값이 0이면 주사위 바닥면에 해당 위치 값 복사
 * 4). 0이 아니면 칸의 값이 주사위 바닥면으로 복사
 * 5). 지도를 탈출할 것 같은 명령어는 무시 + 출력 X
 * */
public class B_14499 {
    static int n, m, x, y, k;
    static int[] dice;
    static int[] comm;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        dice = new int[7];

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        comm = new int[k];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < k; i++){
            comm[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < k; i++){
            int commend = comm[i] - 1;

            x = x + dx[commend];
            y = y + dy[commend];
            if(x < 0 || x >= n || y < 0 || y >= m) continue;

            if(commend == 0) right();
            else if(commend == 1) left();
            else if(commend == 2) up();
            else down();

            if(board[x][y] == 0) {
                board[x][y] = dice[6];
            } else {
                dice[6] = board[x][y];
                board[x][y] = 0;
            }
            sb.append(dice[1]).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void up() {
        int tmp = dice[1];
        dice[1] = dice[5];
        dice[5] = dice[6];
        dice[6] = dice[2];
        dice[2] = tmp;
    }

    public static void down() {
        int tmp = dice[1];
        dice[1] = dice[2];
        dice[2] = dice[6];
        dice[6] = dice[5];
        dice[5] = tmp;
    }

    public static void left() {
        int tmp = dice[1];
        dice[1] = dice[3];
        dice[3] = dice[6];
        dice[6] = dice[4];
        dice[4] = tmp;
    }

    public static void right() {
        int tmp = dice[1];
        dice[1] = dice[4];
        dice[4] = dice[6];
        dice[6] = dice[3];
        dice[3] = tmp;
    }
}
