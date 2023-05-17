package tmax;

import java.util.Arrays;

public class Solution2_2 {
    public int solution(int x, int y, int m, int[] skills) {
        Arrays.sort(skills);

        int cnt = 0;
        int idx = skills.length - 1;
        while(m > x) {
            if(m - skills[idx] > x) {
                cnt++;
                m -= skills[idx];
            }
            else idx--;

            if(idx < 0) {
                idx++;
                break;
            }
        }

        m += skills[idx];

        while(m > 0) {
            m -= skills[skills.length - 1];
            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution2_2 s = new Solution2_2();
        System.out.println(s.solution(30, 10, 50, new int[]{1, 5, 10, 15}));
    }
}
