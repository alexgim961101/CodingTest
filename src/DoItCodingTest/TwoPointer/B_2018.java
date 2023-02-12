package DoItCodingTest.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 연속된 자연수의 합 구하기 / 실버 5 / 시간 제한 2초
 * */
public class B_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = i;
        }

        int count = 1;

        int left = 1;
        int right = 1;
        int sum = arr[left];
        while (right < N) {
            if(sum == N) {
                count++;
                right++;
                sum += arr[right];
            } else if(sum < N) {
                right++;
                sum += arr[right];
            } else {
                sum -= arr[left];
                left++;
            }
        }
        System.out.print(count);
    }
}
