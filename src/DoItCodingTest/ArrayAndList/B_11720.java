package DoItCodingTest.ArrayAndList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 숫자의 합 구하기 / 브론즈 4 / 시간제한 1초
 * 1. 입력
 * 2. 문자열로 숫자를 받은 후 문자 배열로 변환 -> 하나씩 더한다
 * */
public class B_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        // 입력
        int n = Integer.parseInt(br.readLine());
        String num = br.readLine();

        for(char c : num.toCharArray()){
            answer += (c - '0');
        }

        System.out.println(answer);
    }
}
