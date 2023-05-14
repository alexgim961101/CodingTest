package techit.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i < N; i++){
            int value = Integer.parseInt(br.readLine());

            if(value == 0) stk.pop();
            else stk.push(value);
        }

        int answer = 0;
        for(int i : stk) {
            answer += i;
        }

        System.out.println(answer);
    }
}
