package DoItCodingTest.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ATM 인출 시간 계산하기 / 실버 3
 *
 * 문제 요약
 * - ATM 기기 앞에 N명의 사람들이 대기
 * - 각 사람마다 돈을 인출하는 시간이 다름
 * - 모든 사람이 돈을 인출하는데 필요한 최소 시간은?
 *
 * 문제 해결 알고리즘
 * - 정렬 (오름차순으로 정렬)
 * */
public class B_11399 {
    static int n;
    static int[] arr;
    static int[] periodSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        periodSum = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 삽입 정렬
        for(int i = 2; i <= n; i++){
            int value = arr[i];
            int j = i - 1;
            while(j >= 1 && arr[j] > value) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = value;
        }

        for(int i = 1; i <= n; i++){
            periodSum[i] = arr[i] + periodSum[i-1];
        }

        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += periodSum[i];
        }
        System.out.print(sum);
    }
}
