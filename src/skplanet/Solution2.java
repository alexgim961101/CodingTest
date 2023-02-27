package skplanet;

import java.util.HashMap;

/**
 * 해쉬Map을 이용해야 시간초과 안남 + union-find 알고리즘도 같이 구현
 * */
public class Solution2 {

    static int[] people;
    public int[] solution(int[] p, int[] b) {
        int[] answer = new int[b.length];
        people = p;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < people.length; i++){
            find(i);
        }
        for(int x : people){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int idx = 0;

        for(int x : b){
            boolean flag = false;
            int peopleCount = 0;
            if(people[x] == -1) {
                peopleCount = map.get(x) + 1;
            } else {

                flag = true;
            }
            answer[idx] = flag ? 0 : peopleCount;
            idx++;
        }
        return answer;
    }

    public int find(int a){
        if(people[a] == -1) return a;
        else return people[a] = find(people[a]);
    }
    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
        System.out.println(s2.solution(new int[]{2, 2, -1, 1, 5, -1, 5}, new int[]{2, 5}));
    }
}
