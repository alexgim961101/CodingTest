package inflearn.extream.simul;

// 1. 현수와 강아지의 위치 찾기
// 2. 반복문을 계속 돌면서 (10000번이 되면 break)
// 3. 강아지와 현수의 위치가 겹치면 break;
public class LoseDog {
    public int solution(int[][] board) {
        // 초기 변수 설정
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        Point human = null;
        int hDir = 0;
        Point dog = null;
        int dDir = 0;

        int answer = 0;

        // 1.
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                int num = board[i][j];

                if(num == 2) human = new Point(j, i);
                else if(num ==  3) dog = new Point(j, i);
            }
        }

        // 2.
        for(int i = 0; i < 10000; i++) {
            if(human.x == dog.x && human.y == dog.y) {
                answer = i;
                break;
            }

            // 현수의 이동
            int nxHuman = human.x + dx[hDir];
            int nyHuman = human.y + dy[hDir];
            if(nxHuman < 0 || nxHuman >= 10 || nyHuman < 0 || nyHuman >= 10 || board[nyHuman][nxHuman] == 1) {
                hDir = (hDir + 1) % 4;
            } else {
                human.x = nxHuman;
                human.y = nyHuman;
            }

            // 강아지의 이동
            int nxDog = dog.x + dx[dDir];
            int nyDog = dog.y + dy[dDir];
            if(nxDog < 0 || nxDog >= 10 || nyDog < 0 || nyDog >= 10 || board[nyDog][nxDog] == 1) {
                dDir = (dDir + 1) % 4;
            } else {
                dog.x = nxDog;
                dog.y = nyDog;
            }

        }

        return answer;
    }
    public static void main(String[] args) {
        LoseDog T = new LoseDog();
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

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
