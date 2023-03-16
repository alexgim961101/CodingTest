package DoItCodingTest.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 / 실버 1 / 미로탐색
 * */
public class B_2178 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        dist = new int[N][M];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        BFS(0, 0);

        System.out.print(dist[N-1][M-1]);
    }

    private static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        visited[y][x] = true;
        dist[y][x] = 1;
        queue.offer(new Point(x, y));

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if(visited[ny][nx] || map[ny][nx] == 0) continue;

                visited[ny][nx] = true;
                dist[ny][nx] = dist[now.y][now.x] + 1;
                queue.offer(new Point(nx, ny));
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
