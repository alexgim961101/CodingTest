package DoItCodingTest.StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 백준 / 카드 2 / 실버 4
 * 해결 순서
 * 1). 큐를 선언
 * 2). 먼저 큐에 1 부터 n 까지 순서대로 offer
 * 3). 그 후 queue.poll
 * 4). 그 다음 다시 queue.poll한 값을 queue에 offer
 * 5). 위의 가정을 queue.size() == 1 이 될 때까지 반복
 * */
public class B_2164 {
    static int n;
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        queue = new LinkedList<>();
    }

    public static void output() {
        System.out.print(queue.poll());
    }

    public static void process() {
        for(int i = 1; i <= n; i++){
            queue.offer(i);
        }

        while (queue.size() != 1) {
            queue.poll();
            int value = queue.poll();
            queue.offer(value);
        }
    }
}
