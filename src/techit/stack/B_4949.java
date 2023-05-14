package techit.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();

            if(str.equals(".")) break;

            Stack<Character> stk = new Stack<>();

            boolean flag = true;
            for(char ch : str.toCharArray()) {
                if(ch == '(' || ch == '[') {
                    stk.push(ch);
                    continue;
                }

                if(stk.isEmpty() && (ch == ')' || ch == ']')) {
                    flag = false;
                    break;
                } else {
                    if(ch == ')') {
                        if(stk.peek() == '(') stk.pop();
                        else {
                            flag = false;
                            break;
                        }
                    }

                    if(ch == ']') {
                        if(stk.peek() == '[') stk.pop();
                        else {
                            flag = false;
                            break;
                        }
                    }
                }


            }

            if(stk.size() != 0) flag = false;

            sb.append(flag ? "yes\n" : "no\n");
        }

        System.out.print(sb.toString());
    }
}
