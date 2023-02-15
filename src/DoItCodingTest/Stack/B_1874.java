package DoItCodingTest.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 스택 수열 / 실버 2 / 시간 제한 2초 / 메모리 제한 128MB
 * */
public class B_1874 {
    static int n;
    static int[] arr;
    static boolean check;
    static StringBuilder sb;
    public static void main(String[] args) {
        input();
        process();
        output();
    }

    private static void process() {
        Stack<Integer> stk = new Stack<>();

        int count = 1;
        for(int i = 0; i < n; i++){
            int tmp = arr[i];

            if(tmp >= count){
                while (tmp >= count){
                    stk.push(count);
                    count++;
                    sb.append("+\n");
                }
                stk.pop();
                sb.append("-\n");
            } else {
                int num = stk.pop();
                if(num < arr[i]) {
                    check = false;
                    return;
                }  else {
                    sb.append("-\n");
                }
            }
        }
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            check = true;
            sb = new StringBuilder();
            n = Integer.parseInt(br.readLine());
            arr = new int[n];

            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }
        } catch (IOException e) {
            return;
        }
    }

    private static void output() {
        if(check) System.out.print(sb.toString());
        else System.out.print("NO");
    }
}
