import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static int[] solution(int N, int[] arr){
        int[] answer = new int[N];

        for(int i = 0; i < N; i++){
            answer[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < N; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                answer[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(kb.readLine());
        int[] arr = new int[N];
        String str = kb.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int x : solution(N, arr)){
            bw.write(x + " ");
        }
        bw.flush();

    }
}
