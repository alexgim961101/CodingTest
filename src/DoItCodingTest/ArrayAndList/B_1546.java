package DoItCodingTest.ArrayAndList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 평균 / 브론즈 1 / 시간 제한 2초
 * 자료형 처리를 어떻게 하냐가 핵심
 * */
public class B_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        double answer = 0;
        double max = -1;

        double[] num = new double[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            double tmp = Double.parseDouble(st.nextToken());
            max = Math.max(max, tmp);
            num[i] = tmp;
        }

        for(int i = 0; i < n; i++){
            answer += num[i]/max * 100;
        }

        answer = answer / n;
        System.out.println(answer);
    }
}
