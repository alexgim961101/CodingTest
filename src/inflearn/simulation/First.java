package inflearn.simulation;

import java.util.Arrays;

/**
 * 시뮬레이션 / 사다리 타기
 * 1). int check[n][r] : n = 가로줄의 수 , r = 사람 수 (세로줄의 수) , value = 0(가로줄 X), 1(가로줄의 왼쪽), 2(가로줄의 오른쪽) => 세로줄 이동 조건을 위한 배열
 * 2). 각 사람번호를 반복문으로 돌림
 * 3). 그 안에 가로줄의 깊이만큼 반복문을 돌림
 * 4). 각 단계를 거치면서 번호를 이동
 * 5). answer에 저장
 * */
public class First {
    
    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];

        for(int i = 1; i <= n; i++) {
            int idx = i - 1;
            for(int j = 0; j < ladder.length; j++) {
                for(int k : ladder[j]) {
                    if(idx == k - 1) {
                        idx++;
                        break;
                    } else if (idx == k) {
                        idx--;
                        break;
                    }
                }
            }
            answer[idx] = (char) (64 + i);
        }

        return answer;
    }
    public static void main(String[] args){
        First T = new First();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
