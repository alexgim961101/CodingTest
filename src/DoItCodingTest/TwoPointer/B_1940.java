package DoItCodingTest.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 주몽(1940) / 실버 4 / 시간 제한 2초 / 메모리 제한 128MB / 문제 유형 : 투 포인터
 * 재료 고유의 번호 두개의 합 = M -> 갑옷 생성
 * 문제 : 주어진 재료 N개를 통해 몇개의 값옷을 만들 수 있을까?
 *
 * 문제 해결 순서
 * 1). 두개의 재료 번호의 합 == M -> 투 포인터 이용
 * 2). 정렬이 필요 -> 정렬을 안하고 투포인터 돌리면 n^2의 시간복잡도 발생
 * */
public class B_1940 {
    static long N, M, count;
    static long[] arr;
    public static void main(String[] args) {
        // 입력 부분
        input();
        // 로직 처리
        process();
        // 출력 처리
        output();

    }

    // 입력값을 받아 저장하는 함수
    public static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        count = 0;
        try {
            N = Long.parseLong(br.readLine());
            M = Long.parseLong(br.readLine());

            arr = new long[(int)N];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++){
                arr[i] = Long.parseLong(st.nextToken());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 출력 처리
    public static void output() {
        System.out.print(count);
    }

    // 핵심 로직 처리
    public static void process() {
        // 배열 정렬
        Arrays.sort(arr);

        int left = 0;              // 왼쪽 포인터
        int right = arr.length-1;             // 오른쪽 포인터

        // 투 포인터 이용
        while(left < right) {
            long sum = arr[left] + arr[right];
            if(sum == M) {
                count++;
                left++;
                right--;
            } else if(sum < M){
                left++;
            } else {
                right--;
            }
        }
    }
}
