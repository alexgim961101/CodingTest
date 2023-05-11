package study;

import java.util.Arrays;
import java.util.Comparator;

public class Camera {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int pos = -30000;

        for(int[] route : routes) {
            if(pos < route[0]) {
                pos = route[1];
                answer++;
            }
        }

        return answer;
    }
}
