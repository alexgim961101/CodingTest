package tmax;

import java.util.*;

/**
 * 웰 노운 문제 : 한 문제 이상 푼 유저 중 절반 이상이 푼 문제
 * 조건 : 사전 순 정렬, 문제 이름 중복 X, 한 유저가 동일한 문제를 여러 번 해결하는 경우 존재 (핵심)
 *
 * 해결 로직
 * 1). logs를 set으로 필터링해서 한 유저가 동일한 문제를 여러번 푼 경우를 제거
 * 2). userSet과 문제map을 만들어 각각 유저의 수와 문제 별 푼 유저수를 기록
 * 3). map을 탐색하면서 value가 유저 수의 절반 이상이면 저장
 * 4). 정렬 후 return
 * */
public class Solution1 {
    public String[] solution(String[] logs) {
        // 1번 로직
        Set<String> set = new HashSet<>();
        for(int i = 0; i < logs.length; i++){
            set.add(logs[i]);
        }

        String[] strArr = set.toArray(new String[0]);

        // 2번 로직
        Set<String> userSet = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();

        for(String str : strArr) {
            String[] tmp = str.split(" ");

            userSet.add(tmp[0]);
            map.put(tmp[0], map.getOrDefault(tmp[0], 0) + 1);
        }

        //3번 로직
        ArrayList<String> list = new ArrayList<>();
        int mid = userSet.size() % 2 == 0 ? userSet.size() / 2 : (userSet.size() / 2) + 1;
        for(String key : map.keySet()) {
            if(map.get(key) >= mid) list.add(key);
        }

        //4번 로직
        Collections.sort(list);

        return list.toArray(new String[0]);
    }
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String[] str = {"morgan sqrt", "morgan sqrt", "alex sort"};
        solution1.solution(str);
    }
}
