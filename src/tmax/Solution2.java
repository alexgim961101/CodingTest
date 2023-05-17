package tmax;

import java.util.LinkedList;
import java.util.Queue;

/**
 * bfs로 해결하면 될 듯?
 *
 * 해결 로직
 * 1). BFS 로직을 이용
 * 2). 몬스터의 피를 queue에 저장
 *
 * */
public class Solution2 {

    public int solution(int x, int y, int m, int[] skills) {
        int answer = Integer.MAX_VALUE;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(m);
        int L = 1;
        boolean[] visited = new boolean[m+1];
        visited[m] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;
            for(int i = 0; i < size; i++) {
                int nowHP = queue.poll();

                for(int atk : skills) {
                    int nextHP = nowHP - atk;

                    if(nextHP <= 0) {
                        flag = true;
                        break;
                    }

                    if(nextHP <= x) nextHP += y;
                    if(nextHP >= m || visited[nextHP]) continue;
                    queue.offer(nextHP);
                    visited[nextHP] = true;
                }

                if(flag) break;
            }

            if(flag) break;
            L++;
        }
        answer = L;
        return answer;
    }
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.solution(30, 10, 50, new int[]{1, 5, 10 ,15, 20}));
    }
}
