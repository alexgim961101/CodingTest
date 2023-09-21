package inflearn.extream.simul;


import java.util.Arrays;

/**
 * 문제 해결
 *
 * 1). board와 비슷한 visited 배열 생성
 * 2). 0, 1, 2, 3(위 오른쪽, 아래, 왼쪽) 으로 방향 지정
 * 3). dfs(현재 x위치, 현재 y위치, 현재 보는 방향, 현재 움직인 시간) 으로 탐색
 * 4). if(board[y][x] == 0 && visited[y][x]) 일때만 움직일 수 있다. + board 범위 내
 * 5). 현재 방향으로 움직일 수 있으면 움직인 후  시간++
 * 6). 현재 방향으로 움직이지 못하면 시계 방향으로 회전 후 시간++, 움직인 후 시간++
 * */
public class Cleaning {
    public int[] solution(int[][] board, int k) {
        int[] answer = new int[2];

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        int x = 0;
        int y = 0;
        int count = 0;
        int dir = 1;

        while(count < k) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            count++;

            if(nx < 0 || nx >= board.length || ny < 0 || ny >= board.length || board[ny][nx] == 1) {
                dir = (dir + 1) % 4;
                continue;
            }

            x = nx;
            y = ny;
        }

        answer[1] = x;
        answer[0] = y;
        return answer;
    }

    public static void main(String[] args) {
        Cleaning T = new Cleaning();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));
    }
}
