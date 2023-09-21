package DoItCodingTest.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * B_1546 / 브론즈 1 / 평균 구하기
 *
 * 1). 문제 요약
 * - 자기 점수의 최댓값 : M
 * - 모든 점수 / M * 100
 * - 새로 바뀐 점수로 다시 평균 구하기
 *
 * 2). 얻어갈 지식
 * - 나누기 연산시 double 자료형으로 진행할 것
 * */
public class B_1546 {
    static int N;
    static Double answer = 0d;
    static Double[] score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        score = new Double[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Double max = 0d;
        for(int i = 0; i < N; i++) {
            Double tmp = Double.parseDouble(st.nextToken());
            max = Math.max(max, tmp);
            score[i] = tmp;
        }

        for(int i = 0; i < N; i++) {
            score[i] = score[i] / max * 100;
            answer += score[i];
        }

        System.out.println(answer / N);
    }
}
