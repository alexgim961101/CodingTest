package DoItCodingTest.greedy;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 백준 / 골드 4 / 수를 묶어서 최댓값 만들기
 * */
public class B_1744 {
    static int N, answer;
    static PriorityQueue<Integer> pq1, pq2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        answer = 0;

        pq1 = new PriorityQueue<>(Comparator.reverseOrder());            // 양수 담당
        pq2 = new PriorityQueue<>();                                     // 음수 담당

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 1) answer += num;
            else if(num <= 0) {
                pq2.offer(num);
            } else {
                pq1.offer(num);
            }
        }

        while (!pq1.isEmpty()) {
            int num1 = pq1.poll();
            if(pq1.isEmpty()) {
                answer += num1;
                break;
            }
            int num2 = pq1.poll();

            answer += (num1 * num2);
        }

        while (!pq2.isEmpty()) {
            int num1 = pq2.poll();
            if(pq2.isEmpty()) {
                answer += num1;
                break;
            }
            int num2 = pq2.poll();

            answer += (num1 * num2);
        }

        bw.append(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
