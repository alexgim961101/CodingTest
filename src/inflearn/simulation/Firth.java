package inflearn.simulation;

import java.util.Arrays;

public class Firth {
    int[][] board;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int[] solution(int c, int r, int k){
        int[] answer = new int[2];

        board = new int[r][c];

        if(r * c < k) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }

        int x = 0;
        int y = 0;
        int dir = 0;
        board[y][x] = 1;
        k--;
        while(k > 0) {
            x = x + dx[dir];
            y = y + dy[dir];

            if(x < 0 || x >= c || y < 0 || y >= r || board[y][x] != 0) {
                x = x - dx[dir];
                y = y - dy[dir];
                dir = (dir + 1) % 4;
                continue;
            }

            board[y][x] = 1;
            k--;
        }

        answer[0] = x + 1;
        answer[1] = y + 1;
        return answer;
    }

    public static void main(String[] args){
        Firth T = new Firth();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
