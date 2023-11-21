import java.io.*;
import java.util.*;

/**
* 문제해결
*
* 1). targets의 원소를 하나 꺼냄
* 2). 원소의 문자를 하나씩 탐색
* 3). 탐색하면서 keymap의 원소들 비교
* 4). 원소의 문자가 가장 빨리 나오는 경우를 answer + 빨리 나왔을 때의 버튼 누른 횟수
* 5). 전체 반복
*/

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        // targets에서 하나의 원소 선택
        int idx = 0;
        for(String target : targets) {
            int sum = 0;
            boolean flag = true;
            for(char ch : target.toCharArray()) {
                int minCnt = Integer.MAX_VALUE;
                for(String key : keymap) {
                    for(int i = 0; i < key.length(); i++) {
                        if(key.charAt(i) == ch) {
                            minCnt = Math.min(minCnt, i + 1);
                            break;
                        }
                    }
                }
                if(minCnt == Integer.MAX_VALUE) {
                    flag = false;
                    break;
                } else {
                    sum += minCnt;   
                }
            }
            if(flag) answer[idx++] = sum;
            else answer[idx++] = -1;
        }
        
        return answer;
    }
}