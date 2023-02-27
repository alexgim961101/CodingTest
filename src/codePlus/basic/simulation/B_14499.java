package codePlus.basic.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주사위 굴리기 / 골드 4 / 시간제한 2초 / 메모리 제한 512MB
 * 해결 순서
 *
 * */
public class B_14499 {

    static int N, M; // 세로, 가로
    static int x, y; // 행, 열
    static int k; // 명령 개수
    static int[][] map;  // 지도
    static int[] dx = {0, 0, -1, 1};  // 행 기준 동서북남
    static int[] dy = {1, -1, 0, 0};  // 열 기준 동서북남
    static int[] comm; // 명령어 저장
    static int[] dice = new int[6];  // 주사위

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        comm = new int[k];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++){
            comm[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        for(int commend : comm){
            int nx = x + dx[commend];
            int ny = y + dy[commend];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }

            if(commend == 0){  // 동쪽으로 이동
                int tmp = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[2];
                dice[2] = tmp;
            } else if (commend == 1) {  // 서쪽으로 이동
                int tmp = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[5];
                dice[5] = dice[3];
                dice[3] = tmp;
            } else if (commend == 3) {  // 남쪽으로 이동
                int tmp = dice[0];
                dice[0] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[4];
                dice[4] = tmp;
            } else {                    // 북쪽으로 이동
                int tmp = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[1];
                dice[1] = tmp;
            }

            if(map[nx][ny] == 0) {
                map[nx][ny] = dice[5];
            } else {
                dice[5] = map[nx][ny];
                map[nx][ny] = 0;
            }

            x = nx;
            y = ny;
            sb.append(dice[0]).append("\n");
        }

        System.out.print(sb.toString());
    }
}
