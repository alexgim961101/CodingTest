package beakjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 18258 / 큐 2
 * */
public class B_18258 {
    static int N;
    static Deque<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        queue = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String comm = st.nextToken();

            switch (comm) {
                case "push":
                    int n = Integer.parseInt(st.nextToken());
                    queue.offer(n);
                    break;
                case "pop":
                    if(queue.size() == 0) sb.append("-1\n");
                    else sb.append(String.valueOf(queue.poll())).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if(queue.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if(queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.getFirst()).append("\n");
                    break;
                case "back":
                    if(queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.getLast()).append("\n");
                    break;
            }
        }
        System.out.print(sb.toString());
    }
}
