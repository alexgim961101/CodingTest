import java.util.*;
class Debug {
    static int answer;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] dist;
    boolean[][] visited;
    public int solution(int[][] M, int[] S, int[] D) {

        dist = new int[M.length][M[0].length];
        visited = new boolean[M.length][M[0].length];
        answer = 0;

        Queue<Point> queue = new LinkedList<>();
        visited[S[1]][S[0]] = true;
        queue.offer(new Point(S[0], S[1]));

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= M[0].length || ny < 0 || ny >= M.length) continue;
                if(M[ny][nx] == 1 || visited[ny][nx]) continue;

                visited[ny][nx] = true;
                dist[ny][nx] = dist[now.y][now.x] + 1;
                queue.offer(new Point(nx, ny));
            }
        }

        int minDist =  dist[D[1]][D[0]] == 0 ? -1 : dist[D[1]][D[0]];
        visited = new boolean[M.length][M[0].length];
        visited[S[1]][S[0]] = true;
        DFS(new Point(S[0], S[1]), new Point(D[0], D[1]), 0, minDist, M);

        return answer;
    }

    public void DFS(Point start, Point end, int depth, int minDist, int[][] M) {
        if(depth > minDist) return;
        if(depth == minDist && start.x == end.x && start.y == end.y) {
            answer++;
            return;
        }
        for(int i = 0; i < 4; i++) {
            int nx = start.x + dx[i];
            int ny = start.y + dy[i];

            if(nx < 0 || nx >= M[0].length || ny < 0 || ny >= M.length) continue;
            if(M[ny][nx] == 1 || visited[ny][nx]) continue;
            visited[ny][nx] = true;
            DFS(new Point(nx, ny), end, depth+1, minDist, M);
            visited[ny][nx] = false;
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Debug s = new Debug();
        System.out.print(s.solution(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}, new int[]{0, 0}, new int[]{2, 2}));
    }
}