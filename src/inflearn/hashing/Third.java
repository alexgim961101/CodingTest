package inflearn.hashing;

import java.util.HashMap;
import java.util.Map;

public class Third {
    public int solution(String s){
        int answer = 0;

        int length = s.length();
        boolean[] visited = new boolean[length + 1];
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < length; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(char key : map.keySet()) {
            Integer tmp = map.get(key);
            if(!visited[tmp]) visited[tmp] = true;
            else {
                while (visited[tmp] && tmp > 0) {
                    tmp--;
                    answer++;
                }
                visited[tmp] = true;
            }
        }

        return answer;
    }
    public static void main(String[] args){
        Third T = new Third();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
