package DoItCodingTest.StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 11286번 / 절댓값 힙 / 실버 1 / 우선순위 큐
 * 우선순위 큐와 정렬 기준만 잘 잡으면 해결 가능
 * */
public class B_11286 {
    static int n;
    static int[] arr;
    static PriorityQueue<Integer> priorityQueue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for(int i = 0; i < n; i++){
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;
        }

        priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if(abs1 == abs2) return o1 > o2 ? 1 : -1;
            else return abs1 - abs2;
        });

        StringBuilder sb = new StringBuilder();

        for(int x : arr){
            if(x != 0) priorityQueue.offer(x);
            else {
                if(priorityQueue.size() == 0) {
                    sb.append(0).append("\n");
                } else {
                    int value = priorityQueue.poll();
                    sb.append(value).append("\n");
                }
            }
        }

        System.out.print(sb.toString());
    }
}
