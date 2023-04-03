package DoItCodingTest.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 / 잃어버린 괄호 / 실버 2
 * */
public class B_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        ArrayList<Integer> answer = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String numArr = st.nextToken();
            StringTokenizer st2 = new StringTokenizer(numArr, "+");

            int tmp = 0;
            while (st2.hasMoreTokens()) {
                int num = Integer.parseInt(st2.nextToken());
                tmp += num;
            }
            answer.add(tmp);
        }

        if(answer.size() == 1) System.out.print(answer.get(0));
        else {
            int result = answer.get(0);
            for(int i = 1; i < answer.size(); i++){
                result -= answer.get(i);
            }
            System.out.print(result);
        }
    }
}
