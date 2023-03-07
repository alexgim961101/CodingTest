package programmers.lv2;


import java.util.HashMap;

/**
 * 프로그래머스 Lv.2 위장
 * 문제 요약
 * [의상 이름, 종류] 의 2차원 배열이 입력으로 주어졌을 때, 서로 다른 옷의 조합의 수를 return
 *
 * 해결 방법
 * 1). Map에 각 옷 종류별로 몇개씩 있는지 저장
 * 2). 경우의 수 계산 (종류 별로 가지고 있는 옷의 갯수 + 1을 해줘야함 because 해당 옷 종류에서 안입는 다는 조건도 포함해야 하기 때문에)
 * 3). 마지막에 -1 하기
 * */
public class Camouflage {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();
        for(String[] strArr : clothes) {
            String key = strArr[1];
            String value = strArr[0];

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for(String key : map.keySet()){
            answer *= map.get(key) + 1;
        }
        return answer - 1;
    }
}