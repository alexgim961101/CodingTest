package inflearn.extream.simul;

import java.util.Arrays;

/**
 * 문제 해결
 *
 * 1). 1번 사다리 타기 시작
 * 2). 사다리의 깊이는 ladder.length;
 * 3). 사다리로 내려오면서 ladder[현재 사다리 단계][i] 의 값에 현재 사다리의 위치가 있는지 확인
 * 4). 현재 사다리의 위치가 있으면 오른쪽 사다리로 이동
 * 5). 사다리로 내려오면서 ladder[현재 사다리 단계][i] + 1 의 값에 현재 사다리의 위치가 있는지 확인
 * 6). 현재 사다리의 위치가 있으면 왼쪽 사다리로 이동
 * 7). 마지막까지 반복
 * 8). 도착한 순서대로 A, B, C, D... 부여
 * */
public class WorkingLadder {
    public char[] solution(int n, int[][] ladder) {
        char[] answer = new char[n];

        int depth = ladder.length;
        for(int i = 1; i <= n; i++) {
            int nowPos = i;
            for(int j = 0; j < depth; j++) {

                for(int pos : ladder[j]) {
                    if(nowPos == pos) {
                        nowPos++;
                        break;
                    } else if(nowPos == pos + 1) {
                        nowPos--;
                        break;
                    }
                }
            }

            answer[nowPos - 1] = (char) ('A' - 1 + i);
        }

        return answer;
    }

    public static void main(String[] args) {
        WorkingLadder T = new WorkingLadder();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
