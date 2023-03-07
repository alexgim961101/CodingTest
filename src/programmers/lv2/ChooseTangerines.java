package programmers.lv2;

import java.util.*;

/**
 * 프로그래머스 Lv2. 귤 고르기
 * 문제 요약
 * 배열이 주어지고 k의 값이 주어질 때, 배열에서 k개를 선택할 때 서로 다른 종류의 수의 최솟값은?
 *
 * 해결 방법
 * 1). 배열을 전체 탐색하여 각 숫자별로 몇개 있는지 확인 (Map 이용)
 * 2). Map에서 개수를 기준으로 내림차순 정렬
 * 3). k > 0 기준으로 반복문을 돌리면서 map의 key-value 쌍을 얻어냄 -> (k -= value 반복)
 * 4). 해당 반복문 기준에 false가 될 시, break 후 반복한 횟수를 결과값으로 return
 * */
public class ChooseTangerines {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        // 트리 맵에 자료 저장
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
        }

        // treemap을 내림차순으로 저장한 후 List로 변환
        Comparator<Integer> valueComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer v1 = map.get(o1);
                Integer v2 = map.get(o2);
                return v2.compareTo(v1);
            }
        };
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, valueComparator);

        for(int x : list){
            k -= map.get(x);
            answer++;
            if(k <= 0) break;
        }

        return answer;
    }

    public static void main(String[] args) {
        ChooseTangerines c = new ChooseTangerines();
        System.out.println(c.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    }
}
