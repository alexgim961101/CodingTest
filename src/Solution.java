import java.io.*;
import java.util.*;

/**
 * 해결 순서
 * 1). orders의 각 문자열들을 오름차순으로 정렬 -> 원소 조합을 찾기에 유리할 듯?
 * 2). course[i]의 길이만큼 나올 수 있는 조합을 구함
 * 3). 구한 조합을 이용하여 orders배열에서 얼마나 사용되었는지 확인 (HashMap 사용)
 * 4).
 */

class Solution {
    static HashMap<String, Integer> map;

    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        // 1.
        for(int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        // 2.
        for(int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < orders.length; j++) {
                StringBuilder sb = new StringBuilder();
                if(course[i] <= orders[i].length()) combi(orders[i], sb, 0, 0, course[i]);
            }

            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                max = Math.max(max, entry.getValue());
            }

            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                if(max >= 2 && entry.getValue() == max) answer.add(entry.getKey());
            }
        }

        Collections.sort(answer);

        return answer;
    }

    public static void combi(String str, StringBuilder sb, int idx, int cnt, int n) {
        if(cnt == n) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for(int i = idx; i < str.length(); i++) {
            sb.append(str.charAt(i));
            combi(str, sb, i+1, cnt+1, n);
            sb.delete(cnt, cnt + 1);
        }
    }
}
