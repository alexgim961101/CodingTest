package inflearn.simulation;

public class Third {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    public int solution(int[][] board){
        Point person = null;
        Point dog = null;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == 2) person =  new Point(j, i);
                if(board[i][j] == 3) dog = new Point(j, i);
            }
        }

        int time = 0;
        int dogDir = 0;
        int personDir = 0;
        while (time < 10000){
            time++;
            int dogNx = dog.x + dx[dogDir];
            int dogNy = dog.y = dy[dogDir];

            int personNx = person.x + dx[personDir];
            int personNy = person.y + dy[personDir];

            boolean f1 = false;
            boolean f2 = false;

            if(personNx < 0 || personNx >= board.length || personNy < 0 || personNy >= board.length || board[personNy][personNx] == 1){
                personDir = (personDir + 1) % 4;
                f1 = true;
            }

            if(dogNx < 0 || dogNx >= board.length || dogNy < 0 || dogNy >= board.length || board[dogNy][dogNx] == 1){
                dogDir = (dogDir + 1) % 4;
                f2 = true;
            }

            if(!f1) {
                person.x = personNx;
                person.y = personNy;
            }

            if(!f2) {
                dog.x = dogNx;
                dog.y = dogNy;
            }
            if(person.x == dog.x && person.y == dog.y) break;
        }

        return time >= 10000 ? 0 : time;
    }

    public static void main(String[] args){
        Third T = new Third();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}
