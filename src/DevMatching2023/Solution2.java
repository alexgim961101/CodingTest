package DevMatching2023;

public class Solution2 {
    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    int answer = 0;
    boolean[][] visited;
    public int solution(int[][] phone) {

        visited = new boolean[phone.length][phone[0].length];
        for(int i = 0; i < phone.length; i++){
            for(int j = 0; j < phone[0].length; j++){
                if(!visited[i][j] && phone[i][j] == 1) {
                    visited[i][j] = true;
                    dfs(j, i, 1, phone);
                    visited[i][j] = false;
                }
            }
        }

        return answer;
    }

    public void dfs(int x, int y, int depth, int[][] phone) {
        if (depth >= 2) answer++;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= 3 || ny < 0 || ny >= 4) continue;
            if (!visited[ny][nx] && phone[ny][nx] == 1) {
                visited[ny][nx] = true;
                dfs(nx, ny, depth + 1, phone);
                visited[ny][nx] = false;
            }
        }
    }
}
