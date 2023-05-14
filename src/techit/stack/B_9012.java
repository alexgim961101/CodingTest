package techit.stack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 예외
 * 1). 스택이 비어있을 경우에 ) 가 들어옴
 * 2). 마지막에 스택 사이즈가 0이 아닌 경우
 * 3).
 * */
public class B_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String[] str = br.readLine().split("");

            Stack<String> stk = new Stack<>();
            boolean flag = true;
            for(String ch : str) {
                if(ch.equals(")") && stk.isEmpty()) {
                    flag = false;
                    break;
                } else if(ch.equals("(")) {
                    stk.push("(");
                } else {
                    stk.pop();
                }
            }

            if(stk.size() != 0) flag = false;

            sb.append(flag ? "YES\n" : "NO\n");
        }

        System.out.print(sb.toString());
    }
}
