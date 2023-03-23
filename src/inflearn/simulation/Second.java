package inflearn.simulation;

import java.util.Arrays;

public class Second {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];

        Robot robot = new Robot(1, 0, 0);

        while (k-- > 0){
            int nx = robot.nowX + dx[robot.dir];
            int ny = robot.nowY + dy[robot.dir];

            if((nx >= 0 && nx < board[0].length && ny >= 0 && ny < board.length) && (board[ny][nx] == 0)){
                robot.nowX = nx;
                robot.nowY = ny;
            } else {
                robot.dir = (robot.dir + 1) % 4;
            }
        }

        answer[1] = robot.nowX;
        answer[0] = robot.nowY;
        return answer;
    }

    public static void main(String[] args){
        Second T = new Second();
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

    static class Robot {
        int dir;
        int nowX;
        int nowY;

        public Robot(int dir, int nowX, int nowY) {
            this.dir = dir;
            this.nowX = nowX;
            this.nowY = nowY;
        }
    }
}
