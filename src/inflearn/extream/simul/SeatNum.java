package inflearn.extream.simul;

import java.util.Arrays;

// 1. board를 생성
// 2. 문제에서는 시계방향으로 돌지만 문제의 board (1, 1)의 위치와 초기화한 board의 (1, 1)위치가 다름
// 3. 그래서 반시계 방향으로 돌리기
// 4. 방문한 곳은 체크
public class SeatNum {
    public int[] solution(int c, int r, int k) {
        // 0. 변수 초기화
        Point [][] board = new Point[r][c];
        boolean[][] visited = new boolean[r][c];
        Point result = null;
        int[] answer = new int[2];
        int cnt = 1, x = 0, y = 0;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        int dir = 1;

        // 1
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                board[i][j] = new Point(j + 1, i + 1);
            }
        }

        // 2
        while(cnt <= k) {

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || nx >= c || ny < 0 || ny >= r || visited[ny][nx])  {
                dir = (dir + 1) % 4;
                continue;
            }

            cnt++;
            visited[y][x] = true;

            x = nx;
            y = ny;
            result = board[y][x];
        }


        answer[0] = result.x;
        answer[1] = result.y;

        return answer;
    }

    public static void main(String[] args) {
        SeatNum T = new SeatNum();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
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
