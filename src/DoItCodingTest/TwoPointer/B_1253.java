package DoItCodingTest.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 좋다 / 골드 4 / 시간 제한 2초 / 메모리 제한 256MB
 * N개의 수 중 어떤 수를 다른 두 수의 합으로 나타낼 수 있으면 count
 *
 * 해결 순서
 * 1). 배열 오름차순 정렬 -> 투 포인터 로직의 효율성을 위해
 * 2). 반복문을 이용하여 특정 수를 지정
 * 3). 투 포인터가 가르키는 값의 합이 특정 수랑 같은 지 판별
 * 4). 여기서 주의할 점! -> 투포인터가 특정 수를 지정하고 있으면 안됨
 *
 * 시간 복잡도 : n^2 예상 -> 문제의 Max(n) = 2000 이기 때문에 시간 충분
 * */
public class B_1253 {
    static long N, count;
    static long[] arr;
    public static void main(String[] args) {
        input();
        process();
        output();
    }

    // 로직
    private static void process() {
        Arrays.sort(arr);

        for(int i = 0; i < N; i++){
            int left = 0;
            int right = (int) (N-1);

            while(left < right){
                long sum = arr[left] + arr[right];
                if(sum == arr[i]){
                    if(left != i && right != i) {
                        count++;
                        break;
                    } else if(left == i) {
                        left++;
                    } else {
                        right--;
                    }
                } else if(sum < arr[i]){
                    left++;
                } else {
                    right--;
                }
            }
        }
    }

    // 입력 처리
    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        count = 0;
        try {
            N = Long.parseLong(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");

            arr = new long[(int)N];
            for(int i = 0; i < N; i++){
                arr[i] = Long.parseLong(st.nextToken());
            }
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }

    // 출력 처리
    private static void output() {
        System.out.print(count);
    }

}
