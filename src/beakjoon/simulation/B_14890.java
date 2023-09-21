package beakjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 골드 3 / 경사로
 *
 * 문제 해결 순서
 * 1). 각 행과 열을 돌면서 지나갈 수 있는지 체크
 * 2). 이동 방향을 탐색하면서 전 블록과 현재 블록의 높이차이가 1 초과이면 pass, 아니면
 * 3). 그 이후에 경사로를 놔둘 수 있는지 체크
 * 4). 2 ~ 3번을 무사히 빠져나왔으면 count++;
 * */
public class B_14890 {

    static int N, L;
    static int[][] board;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행 검사 (0)
        for(int i = 0; i < N; i++){
            if(check(i, 0)) count++;
        }

        // 열 검사 (1)
        for(int i = 0; i < N; i++) {
            if(check(i, 1)) count++;
        }

        System.out.println(count);
    }

    public static boolean check(int pos, int dir) {
        if(dir == 0) {
            int pre = board[pos][0];
            for(int i = 1; i < N; i++) {
                int now = board[pos][i];


                if(Math.abs(now - pre) > 1) return false;
                else if(Math.abs(now - pre) == 1){
                    if(!isPut(pre, now, pos, dir)) return false;
                }
                pre = now;
            }
            return true;
        } else {
            int pre = board[0][pos];
            for(int i = 1; i < N; i++) {
                int now = board[i][pos];

                if(Math.abs(now - pre) > 1) return false;
                else {
                    if(!isPut(pre, now, pos, dir)) return false;
                }
                pre = now;
            }
            return true;
        }
    }

    private static boolean isPut(int pre, int now, int pos, int dir) {
        if(dir == 0) {
            if (pre + L < N) {
                int base = now;
                for (int i = pre + 1; i <= pre + L; i++) {
                    if (board[pos][i] != base) return false;
                }
                return true;
            } else return false;
        } else {
            if (pre + L < N) {
                int base = now;
                for (int i = pre + 1; i <= pre + L; i++) {
                    if (board[i][pos] != base) return false;
                }
                return true;
            } else return false;
        }
    }
}
