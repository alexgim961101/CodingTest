package tekitStudy.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_10828 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String comm = st.nextToken();

            switch (comm) {
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    stk.push(value);
                    break;
                case "pop":
                    if(stk.isEmpty()) System.out.println(-1);
                    else System.out.println(stk.pop());
                    break;
                case "size":
                    System.out.println(stk.size());
                    break;
                case "empty":
                    System.out.println(stk.isEmpty() ? 1 : 0);
                    break;
                default:
                    System.out.println(stk.isEmpty() ? -1 : stk.peek());
            }
        }
    }
}
