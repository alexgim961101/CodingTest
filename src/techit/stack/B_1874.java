package techit.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int preH = 0;
        Stack<Integer> stk = new Stack<>();
        while(n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if(num < preH) {
                if(stk.peek() == num) {
                    stk.pop();
                    sb.append("-\n");
                    continue;
                } else {
                    System.out.println("NO");
                    return;
                }
            }

            for(int i = preH + 1; i <= num; i++){
                stk.push(i);
                sb.append("+\n");
            }
            stk.pop();
            sb.append("-\n");
            preH = num;


        }

        System.out.print(sb.toString());
    }
}
