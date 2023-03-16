package study;

/**
 * 프로그래머스
 * 문제 요약
 * - 보드가 주어질 때, 해당 상황이 나올 수 있는지 판단
 *
 * 해결 순서
 * 1). O, X의 갯수로 접근? -> O or X가 연속으로 나오는 상황 처리하기가 까다로울 듯
 * 2). 연속으로 나오는 상황 => 8가지 => 그냥 반복문으로 미리 처리???
 * 3). 생각해볼 경우의 수
 * -
 * */
public class TicTacTok {
    static char[][] map = new char[3][3];
    static int oCount = 0;
    static int xCount = 0;

    public int solution(String[] board) {
        int answer = 1;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                char val = board[i].charAt(j);
                if(val == 'O') oCount++;
                if(val == 'X') xCount++;
                map[i][j] = val;
            }
        }

        if(oCount < xCount || oCount - xCount > 1 || (check('O') == true && check('X') == true) || (check('O') && (oCount == xCount)) || (check('X') && (oCount > xCount))) return 0;
        else return answer;
    }

    public boolean check(char c) {
        for(int i = 0; i < 3; i++) {
            if(map[i][0] == c && map[i][1] == c && map[i][2] == c) return true;
            if(map[0][i] == c && map[1][i] == c && map[2][i] == c) return true;
        }

        if(map[0][0] == c && map[1][1] == c && map[2][2] == c) return true;
        if(map[0][2] == c && map[1][1] == c && map[2][1] == c) return true;

        return false;
    }

    public static void main(String[] args) {
        TicTacTok t = new TicTacTok();
        System.out.print(t.solution(new String[]{"OOO", "...", "XXX"}));
    }
}
