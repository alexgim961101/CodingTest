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

        int count = 1; // N은 기본으로 포함한다는 의미 -> 투 포인터로 잡기 힘듬

        int left = 1;
        int right = 1;         // 1 <= N 이라는 조건 때문에 2를 넣을 수 없음 -> 바로 index에러 발생
        int sum = arr[left];   // left == right 상태는 존재 할 수 없기 때문에 처음에 arr[left]만 더함
        while (right < N) {    // right = N 이 되면 left에 어떤 값이 와도 count++ 할 수 없기 때문
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
