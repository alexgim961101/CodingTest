package inflearn.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Second {
    public int[] solution(String s){
        int[] answer = new int[5];

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int max = -1;
        for(char ch : map.keySet()) {
            max = Math.max(max, map.get(ch));
        }

        for(int i = 0; i < 5; i++){
            char ch = (char)('a' + i);
            int dif = max - map.getOrDefault(ch, 0);
            answer[i] = dif;
        }

        return answer;
    }

    public static void main(String[] args){
        Second T = new Second();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
