package codePlus.basic.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배열 돌리기 3 / (실버 1) / 시간 제한 2초
 * */
public class B_16935 {
    static int N, M, R;
    static int[][] board;
    static int[] comm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        comm = new int[R];
        board = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < R; i++){
            comm[i] = Integer.parseInt(st.nextToken());
        }

        for(int commend : comm) {
            switch (commend){
                case 1:
                    op1();
                    break;
                case 2:
                    op2();
                    break;
                case 3:
                    op3();
                    break;
                case 4:
                    op4();
                    break;
                case 5:
                    op5();
                    break;
                default:
                    op6();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++){
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void op1(){
        int n = board.length;
        int m = board[0].length;
        int[][] b = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                b[i][j] = board[n-1-i][j];
            }
        }
        board = b;
    }
    public static void op2(){
        int n = board.length;
        int m = board[0].length;
        int[][] b = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                b[i][j] = board[i][m-1-j];
            }
        }
        board = b;
    }
    public static void op3(){
        int n = board.length;
        int m = board[0].length;
        int[][] b = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                b[i][j] = board[n-1-j][i];
            }
        }
        board = b;
    }
    public static void op4(){
        int n = board.length;
        int m = board[0].length;
        int[][] b = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                b[i][j] = board[j][m-1-i];
            }
        }
        board = b;

    }
    public static void op5(){
        int n = board.length;
        int m = board[0].length;
        int[][] b = new int[n][m];
        int divN = n/2;
        int divM = m/2;

        for(int i = 0; i < divN; i++){
            for(int j = 0; j < divM; j++){
                b[i][j] = board[i+divN][j];
                b[i][j+divM] = board[i][j];
                b[i+divN][j+divM] = board[i][j+divM];
                b[i+divN][j] = board[i+divN][j+divM];
            }
        }
        board = b;
    }
    public static void op6(){
        int n = board.length;
        int m = board[0].length;
        int[][] b = new int[n][m];
        int divN = n/2;
        int divM = m/2;

        for(int i = 0; i < divN; i++){
            for(int j = 0; j < divM; j++){
                b[i][j] = board[i][j+divM];
                b[i][j+divM] = board[i+divN][j+divM];
                b[i+divN][j+divM] = board[i+divN][j];
                b[i+divN][j] = board[i][j];
            }
        }
        board = b;
    }

}
