package toss;

import java.io.*;

import java.util.*;

public class Second {
    ArrayList<ArrayList<Integer>> friendsList = new ArrayList<>();
    int answer;
    public int solution(int[][] relationships, int target, int limit) {
        answer = 0;

        // 인접 리스트 생성
        for(int i = 0; i < 101; i ++) {
            friendsList.add(new ArrayList<>());
        }

        // 인접 리스트 초기화
        for(int i = 0; i < relationships.length; i++){
            int tmp1 = relationships[i][0];
            int tmp2 = relationships[i][1];

            friendsList.get(tmp1).add(tmp2);
            friendsList.get(tmp2).add(tmp1);
        }

        answer += friendsList.get(target).size() * 5;

        for(int x : friendsList.get(target)) {
            dfs(limit, 1, x, 0);
        }

        return answer;
    }

    public void dfs(int limit, int depth, int target, int cnt){
        if(limit == depth) {
            answer += cnt * 10;
            return;
        }
        else {
            for(int x : friendsList.get(target)) {
                answer++;
                dfs(limit, depth+1, x, cnt+1);
            }
        }
    }
}
