package techit.set;

import java.util.Arrays;

public class PowerSetRecur {
    public static void main(String[] args) {
        int[] set = new int[]{2, 3, 5};
        int[] select = new int[set.length];
        new PowerSetRecur().powerSet(set, select, 0);

    }

    public void powerSet(int[] set, int[] select, int next) {
        if(next == set.length) {
            for(int i = 0; i < set.length; i++){
                if(select[i] == 1) System.out.print(set[i] + " ");
            }
            System.out.println(Arrays.toString(select));
        } else {
            // 내건 고르지 않고 다음거
            select[next] = 0;
            powerSet(set, select, next + 1);
            // 내건 고르고 다음거
            select[next] = 1;
            powerSet(set, select, next + 1);
        }
    }
}
