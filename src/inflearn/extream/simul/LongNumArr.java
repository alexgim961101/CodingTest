package inflearn.extream.simul;


import java.util.ArrayList;
import java.util.Map;

/**
 * 해결방법
 *
 * 최장 길이 바이토닉 수열 -> 봉우리를 찾은 다음 양쪽 비교
 * */
public class LongNumArr {
    public int solution(int[] arr) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i < arr.length - 1; i++) {
            if(arr[i - 1] < arr[i] && arr[i + 1] < arr[i]) list.add(i);
        }

        for(int x : list) {
            int left = x;
            int right = x;
            int cnt = 1;

            while(left - 1 >= 0 && arr[left - 1] < arr[left]) {
                left--;
                cnt++;
            }

            while(right + 1 < arr.length && arr[right + 1] < arr[right]) {
                right++;
                cnt++;
            }

            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        LongNumArr T = new LongNumArr();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
