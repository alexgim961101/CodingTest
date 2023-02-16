package study;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 야근 지수 / 프로그래머스
 * 야근 피로도 = 시그마 (남은 작업량)^2
 * 한 시간동안 1만큼 작업 처리
 * 최소 야근 피로도 return
 *
 * 해결 방법
 * 1). works 배열에서 가장 작업량이 많은 원소를 -1 해줌
 * 2). -1을 했다는 의미는 1시간동안 일했다는 의미이기 때문에 n도 -1 해줌
 * 2-1). 모든 원소가 0이면 반복문 종료
 * 3). n = 0이 될 때까지 1), 2) 를 반복
 * 4). 최종적으로 마지막에 남은 works 배열의 원소들을 제곱한 뒤 더해서 return
 * == > 시간복잡도가 너무 높음 (1,000,000 * 20,000)
 *
 * 해결 방법
 * 1). 위와 비슷하나 정렬 -> 이것도 시간복잡도 장난 아님 (1,000,000log(1,000,000) * 20,000)
 *
 * 해결 방법
 * 1). 우선순위 큐 이용
 * */
public class NightShift {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int work : works){
            queue.offer(work);
        }

        for(int i = 0; i < n; i++){
            int value = queue.poll();
            if(value == 0) break;
            queue.offer(value - 1);
        }

        for(int work : queue){
            answer += work * work;
        }

        return answer;
    }

    public static void main(String[] args) {
        NightShift n = new NightShift();
        System.out.print(n.solution(4, new int[] {4,3,3}));
    }
}
