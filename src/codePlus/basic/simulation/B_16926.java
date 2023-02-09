package codePlus.basic.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 배열 돌리기 1, 2 / 실버 1 / 시간 제한 1초
 * 원처럼 돌리는 문제의 핵심! -> 반복이 존재한다!!!!!
 * */
public class B_16926 {
    static int N, M, R;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 오류나면 99퍼 확율로 여기
        int groupNum = Math.min(N, M) / 2;
        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
        for(int k = 0; k < groupNum; k++) {
            ArrayList<Integer> group = new ArrayList<>();
            // 12방향
            for(int j = k; j < M - k - 1; j++){
                group.add(board[k][j]);
            }
            // 3방향
            for(int j = k; j < N - k - 1; j++){
                group.add(board[j][M-k-1]);
            }
            // 6방향
            for(int j = M-k-1; j > k; j--){
                group.add(board[N-k-1][j]);
            }
            // 9방향
            for(int j = N-k-1; j > k; j--){
                group.add(board[j][k]);
            }

            groups.add(group);
        }

        // 배열 회전 구현
        for(int i = 0; i < groupNum; i++){
            ArrayList<Integer> group = groups.get(i);
            int size = group.size();
            int idx = R % size;
            for(int j = i; j < M - i- 1; j++, idx = (idx+1)%size){
                board[i][j] = group.get(idx);
            }
            // 3방향
            for(int j = i; j < N - i - 1; j++, idx = (idx+1)%size){
                board[j][M-i-1] = group.get(idx);
            }
            // 6방향
            for(int j = M-i-1; j > i; j--, idx = (idx+1)%size){
                board[N-1-i][j] = group.get(idx);
            }
            // 9방향
            for(int j = N-i-1; j > i; j--, idx = (idx+1)%size){
                board[j][i] = group.get(idx);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());

    }
}
