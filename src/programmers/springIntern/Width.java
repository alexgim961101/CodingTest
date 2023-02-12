package programmers.springIntern;

/**
 * 도형의 넓이 구하기
 * 다각형 내부 외부 판별
 *
 * */

public class Width {

    static char[][] board;
    public int solution(String[] grid) {
        int answer = 0;

        board = new char[grid.length][grid[0].length()];

        for(int i = 0; i < grid.length; i++){
            String str = grid[i];
            for(int j = 0; j < grid[0].length(); j++){
                board[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length(); j++){
                if(board[i][j] == '.'){
                    if(check(j, i)) board[i][j] = '#';
                }
            }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length(); j++){
                if(board[i][j] == '#'){
                    answer++;
                }
            }
        }

        return answer;
    }

    public boolean check(int x, int y) {
        int count = 0;
        for(int i = x; i < board[0].length; i++){
            boolean flag = false;
            if(board[y][i] == '#'){
                flag = true;
            }
            if(flag) count++;
            if(i+1 < board[0].length && board[y][i+1] == '#'){
                i++;
            }
        }

        return (count % 2) == 1 ? true : false;
    }
}
