import java.util.*;
import java.io.*;

public class Main {
    public static void solution(int N, int[] A){
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stk = new Stack<>();
        int m = 0;
        for(int x : A){
            if(m < x){
                while(m < x){
                    stk.push(++m);
                    sb.append("+\n");
                }
                stk.pop();
                sb.append("-\n");
            }else{
                if(stk.peek() != x){
                    System.out.println("NO");
                    return;
                }
                stk.pop();
                sb.append("-\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        solution(N, A);
    }
}
