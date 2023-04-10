package inflearn.simulation;

/**
 * ㅂㅣ밀번호
 * 해결 방법
 * 1). 입력 배열을 2차원으로 변환
 * 2). 주어진 문자열 배열로 첫 번째 반복분 생성
 * 3). 그 안에 8방향 반복문을 돌림
 * 4). 다음 이동할 위치가 올바른 위치인지 판단하고 아니면 continue
 * 5). 다음 이동할 위치에 다음 숫자가 있으면 break
 * */
public class Seventh {

    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = {};
    public int solution(int[] keypad, String password){
        int answer = 0;
        int[][] board = new int[3][3];

        int idx = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = keypad[idx++];
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Seventh T = new Seventh();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
