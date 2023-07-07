package study;
import java.util.*;
import java.io.*;

public class GetMinerals {
    int answer = Integer.MAX_VALUE;
    boolean[] usePick = new boolean[3];
    int[] tmpPicks;
    String[] tmpMinerals;
    int[][] score = new int[3][3];
    int totalFati;

    public int solution(int[] picks, String[] minerals) {
        tmpPicks = picks;
        tmpMinerals = minerals;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                score[i][j] = 1;
            }
        }
        score[1][0] = 5;
        score[2][0] = 25;
        score[2][1] = 5;


        for(int i = 0; i < 3; i++){
            int idx = 0;
            int fati = 0;
            totalFati = Integer.MAX_VALUE;
            usePick[i] = true;
            dfs(i, idx, fati, 0);
            usePick[i] = false;
            answer = Math.min(answer, fati);
        }

        return answer;
    }

    // pick : 사용할 삽 , idx : 광물을 어디까지 캤는지 나타냄
    public void dfs(int pick, int idx, int fati, int depth) {
        System.out.println("사용 곡괭이 : " + pick);
        int cnt = tmpPicks[pick];
        for(int i = 0; i < cnt; i++){
            boolean status = true;
            for(int j = 0; j < 5; j++) {
                if(idx >= tmpMinerals.length) {
                    status = false;
                    break;
                }

                String mine = tmpMinerals[idx++];
                int numMine;
                switch(mine) {
                    case "diamond":
                        numMine = 0;
                        break;
                    case "iron":
                        numMine = 1;
                        break;
                    default:
                        numMine = 2;
                }
                System.out.println(score[pick][numMine]);
                fati += score[pick][numMine];
            }

            if(!status) break;
        }

        for(int i = 0; i < 3; i++){
            if(!usePick[i]) {
                usePick[i] = true;
                dfs(i, idx, fati, depth + 1);
                usePick[i] = false;
            }
        }

        if(depth == 2) {
            totalFati = Math.min(totalFati, fati);
        }
    }

    public static void main(String[] args) {
        GetMinerals g = new GetMinerals();
        System.out.print(g.solution(new int[]{0, 1, 1}, new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}));
    }
}
