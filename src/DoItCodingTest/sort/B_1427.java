package DoItCodingTest.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버 5 / 소트인사이드
 * 문제 요약
 * - 수가 주어지면 각 수의 자릿수를 내림차순 정렬
 *
 * 해결 알고리즘
 * - 선택 정렬 (다른 정렬알고리즘도 상관 없음)
 *
 * 문제 해결 순서
 * 1). 주어진 문자열 수를 각 자릿수마다 쪼개서 배열에 저장
 * 2). 수를 저장한 배열을 선택정렬로 내림차순
 * 3). StringBuilder를 이용하여 한번에 출력
 * */
public class B_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 수를 각 자릿수마다 쪼개서 배열에 저장
        int[] numArr = new int[input.length()];
        for(int i = 0; i < input.length(); i++){
            numArr[i] = input.charAt(i) - '0';
        }

        // 선택 정렬
        for(int i = 0; i < numArr.length - 1; i++) {
            int max = Integer.MIN_VALUE;
            int maxIdx = -1;
            for(int j = i; j < numArr.length; j++) {
                if(max < numArr[j]) {
                    max = numArr[j];
                    maxIdx = j;
                }
            }
            int tmp = numArr[i];
            numArr[i] = numArr[maxIdx];
            numArr[maxIdx] = tmp;
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numArr.length; i++){
            sb.append(numArr[i]);
        }
        System.out.print(sb.toString());

    }
}
