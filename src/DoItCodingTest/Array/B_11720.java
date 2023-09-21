package DoItCodingTest.Array;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 11720 / 브론즈 2 / 숫자의 합 구하기
 *
 * 문제 요약
 * 1). 입력으로 주어진 N개의 숫자의 합 구하기 (공백 없이 주어짐)
 *
 * 얻어갈 지식
 * - 숫자 0의 아스키 코드 : 48
 * - 문자열을 숫자로 바꾸는 방법
 * -- 1). str.charAt(index) - 48 or '0'
 * -- 2). str.toCharArray()[index] - 48
 * */
public class B_11720 {
    static int N;
    static int[] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        String str = br.readLine();
        for(int i = 0; i < N; i++) {
            arr[i] = str.charAt(i) - 48;
        }

        for(int i = 0; i < N; i++) {
            answer += arr[i];
        }

        System.out.println(answer);
    }
}
