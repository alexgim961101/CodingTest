package study;

import java.util.Arrays;

/**
 * 해결 방법
 * 1). s를 n으로 나눈 나머지가 0인지 아닌지 판단
 * 2). 0일 경우 s를 n으로 나눈 몫을 답으로 전부 출력
 * 3). 아닐 경우, 나머지 만큼 +1을 해줌
 * 4). 마지막으로 오름차순 정렬
 * */
public class BestSet {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        int rem = s % n;
        int share = s / n;

        if(n > s) {
            return new int[]{-1};
        }

        for(int i = 0; i < n; i++){
            answer[i] = share;
        }

        if(rem != 0) {
            for(int i = 0; i < rem; i++){
                answer[i] += 1;
            }
        }

        Arrays.sort(answer);

        return answer;
    }
}
