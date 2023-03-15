package DoItCodingTest.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 / 골드 5 / 신기한 소수 찾기
 *
 * 에라토스테네스의 체 -> 메모리 초과
 * */
public class B_2023 {
    static int N;
    static int[] arr = {2, 3, 5, 7};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int x : arr) {
            DFS(x);
        }

        System.out.print(sb.toString());
    }

    public static void DFS(int value) {
        if(String.valueOf(value).length() == N) {
            if(check(value)) sb.append(value + "\n");
            return;
        } else {
            for(int i = 1; i <= 9; i++) {
                int nv = value * 10 + i;
                if(check(nv)) DFS(nv);
            }
        }
    }

    // 소수 판별 함수
    public static boolean check(int value) {
        for(int i = 2; i < value/2; i++){
            if(value % i == 0) return false;
        }
        return true;
    }
}
