package DoItCodingTest.greedy;

import java.io.*;
import java.util.PriorityQueue;

/**
 * 백준 / 카드 정렬하기 / 골드 4
 * */
public class B_1715 {
    static int N;
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while (pq.size() != 1) {
            int num1 = pq.poll();
            int num2 = pq.isEmpty() ? 0 : pq.poll();

            int sum = num1 + num2;
            result += sum;

            pq.offer(sum);
        }

        bw.append(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
