package techit.sort;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {25, 12, 18, 24, 2, 21};
        int n = arr.length;

        // 제일 작은 원소를 찾아서 앞으로 보낸다.
        for(int i = 0; i < n - 1; i++) {
            // 제일 앞에를 현재 제릭 작다고 설정
            int minIndex = i;
            // ㅑ + 1부터 끝까지 차근차근 비교
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[minIndex]) minIndex = j;
            }

            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
