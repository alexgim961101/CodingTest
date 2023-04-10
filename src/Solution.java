import java.util.LinkedList;
import java.util.Queue;
class Solution {
    static int answer;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] dist;
    static boolean[][] visited;
    static boolean flag = false;
    static int[] dirCount = {0, 0, 0, 0};
    public String solution(int[][] M, int[] S, int[] D) {

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

        int minDist = dist[D[1]][D[0]];
        visited = new boolean[M.length][M[0].length];
        DFS(new Point(S[0], S[1]), new Point(D[0], D[1]), 0, minDist, M, 0, 0, 0, 0);

        return dirCount[0] + "/" + dirCount[1] + "/" + dirCount[2] + "/" + dirCount[3];
    }

    public void DFS(Point start, Point end, int depth, int minDist, int[][] M, int up, int down, int left, int right) {
        if(flag) return;
        if(depth > minDist) return;
        if(depth == minDist && start.x == end.x && start.y == end.y) {
            flag = true;
            answer++;
            dirCount[0] = up;
            dirCount[1] = down;
            dirCount[2] = left;
            dirCount[3] = right;
            return;
        }
        for(int i = 0; i < 4; i++){
            int nx = start.x + dx[i];
            int ny = start.y + dy[i];

            if(nx < 0 || nx >= M[0].length || ny < 0 || ny >= M.length) continue;
            if(M[ny][nx] == 1 || visited[ny][nx]) continue;

            if(i == 0) up++;
            else if(i == 1) right++;
            else if(i == 2) down++;
            else left++;

            visited[ny][nx] = true;
            DFS(new Point(nx, ny), end, depth+1, minDist, M, up, down, left, right);
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
}