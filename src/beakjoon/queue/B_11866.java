package beakjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 요세푸스 문제 0 / 실버 5
 *
 * */
public class B_11866 {

    static int N, K;
    static Deque<Integer> dq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dq = new ArrayDeque<>();

        for(int i = 1; i <= N; i++) {
            dq.add(i);
        }

        sb.append("<");

        while(!dq.isEmpty()) {
            for(int i = 0; i < K - 1; i++){
                dq.add(dq.pop());
            }
            if(dq.size() == 1) {
                sb.append(dq.pop());
            } else {
                sb.append(dq.pop()).append(", ");
            }
        }

        sb.append(">");

        System.out.print(sb.toString());
    }
}
