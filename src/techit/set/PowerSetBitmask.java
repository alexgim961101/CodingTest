package techit.set;

import java.util.ArrayList;
import java.util.List;

public class PowerSetBitmask {
    public static void main(String[] args) {
        int[] set = {2, 3, 5};
        new PowerSetBitmask().powerSet(set);
    }

    public void powerSet(int[] set) {
        int n = set.length;
        // 집합의 부분집합의 갯수는 2^n개 인데, 1 << n 의 결과도 2^n 이다.
        int subsetCount = 1 << n;
        // i를 2진수로 생각하면,
        // 각 자릿수
        for(int i = 0; i < subsetCount; i++) {
            List<Integer> subset = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0) subset.add(set[j]);
            }
            System.out.println(subset);
        }
    }
}
