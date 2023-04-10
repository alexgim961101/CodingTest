package inflearn.hashing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 해싱 / 한번 사용한 문자
 * */
public class First {
    public int solution(String s){
        int answer = 0;

        // LinkedHashMap => 순서 보장
        Map<Character, Integer> map = new LinkedHashMap<>();

        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        Iterator<Character> iterator = map.keySet().iterator();
        boolean flag = false;
        Character key = null;
        while(iterator.hasNext()) {
            key = iterator.next();
            int value = map.get(key);

            if(value == 1) {
                flag = true;
                break;
            }
        }

        int result = 0;
        if(!flag) result = -1;
        else {
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == key) {
                    result = i + 1;
                    break;
                }
            }
        }

        answer = result;
        return answer;
    }

    public static void main(String[] args){
        First T = new First();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
