package study;

import java.util.Arrays;

/**
 * 프로그래머스 / 연속 펄스 부분 수열의 합
 * 굉장히 dp같음
 * 1, -1 시작이 두개 -> dp 두 개
 *
 * dy[n] := n까지에서 가장 큰 값
 * dy[n] := Max(dy[n-1] + 현재값 (*-1), 현재값)
 * */
public class Sequence {
    public long solution(int[] sequence) {
        long answer = 0;

        long[] dp1 = new long[sequence.length];
        long[] dp2 = new long[sequence.length];

        dp1[0] = sequence[0];
        dp2[0] = dp1[0] * -1;

        for(int i = 1; i < sequence.length; i++){
            long val = sequence[i];

            if(i % 2 == 0) {
                dp1[i] = Math.max(dp1[i-1] + val, val);
                dp2[i] = Math.max(dp2[i-1] + val * -1, val * -1);
            } else {
                dp1[i] = Math.max(dp1[i-1] + val * -1, val * -1);
                dp2[i] = Math.max(dp2[i-1] + val, val);
            }
        }

        Arrays.sort(dp1);
        Arrays.sort(dp2);

        answer = Math.max(dp1[sequence.length-1], dp2[sequence.length-1]);

        return answer;
    }
}
