package skplanet;

/**
 * 완전 탐색
 * */
public class Solution3 {
    static int count = Integer.MIN_VALUE;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int nowX, nowY;
    static String[] board;
    public int[] solution(String[][] boards) {
        int[] answer = new int[boards.length];

        int idx = 0;
        for(String[] tmp : boards){
            board = tmp;
            int zeroCount = 0;
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length(); j++){
                    if(board[i].charAt(j) == '0') zeroCount++;
                    if(board[i].charAt(j) == '2'){
                        nowX = j;
                        nowY = i;
                    }
                }
            }

            int sum = 0;
            // 핵심 로직 부분
            for(int i = 0; i < 4; i++){
                dfs(i, board, sum);
            }

            if(zeroCount == count) answer[idx] = 1;
            else answer[idx] = 0;
            idx++;
            count = 0;
        }

        return answer;
    }

    public void dfs(int dir, String[] board, int sum) {
        int x = dx[dir];
        int y = dy[dir];
        if(nowX+x < 0 || nowX+x >= board[0].length() || nowY+y < 0 || nowY+y >= board.length){
            for(int i = 0; i < 4; i++){
                if(i == dir) continue;
                dfs(i, board, sum);
            }
        } else {
            nowX = nowX + x;
            nowY = nowY + y;
            dfs(dir, board, sum+1);
        }
    }
}
