package DoItCodingTest.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 / 실버 1 / 기타 레슨
 * */
public class B_2343 {
    static int N, M;
    static int[] arr;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int end = 0;
        int start = 0;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            end += arr[i];
            start = Math.max(start, arr[i]);
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            if(check(mid) <= M) {
                result = Math.min(result, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.print(result);
    }

    // 아래 코드는 시간 초과
//    private static void binarySearch(int start, int end) {
//        int middle = (start + end) / 2;
//
//        if(start <= end) {
//            if(check(middle) == 0) {
//                result = Math.min(result, middle);
//                binarySearch(start, middle-1);
//            } else if(check(middle) == 1) {
//                binarySearch(middle+1, end);
//            } else {
//                binarySearch(start, middle-1);
//            }
//        }
//    }

    private static int check(int middle) {
        int sum = 0;
        int count = 0;

        for(int i = 0; i < N; i++){
            sum += arr[i];
            if(sum > middle) {
                count++;
                sum = arr[i];
            }
        }
        if(sum != 0) count++;

        return count;
    }
}
