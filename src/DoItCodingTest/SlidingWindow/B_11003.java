package DoItCodingTest.SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 최솟값 찾기 / 플래 / 시간 제한 2.4초
 * 해결 과정
 * 사용 알고리즘 : two pointer / 자료구조 : deque
 * 1). L의 법위를 벗어나는 인덱스 제거
 * 2). dq를 이용한 정렬
 * */
public class B_11003 {
    static int N, L;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> dq = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        arr  = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void process() {
        for(int i = 0; i < N; i++){
            int nowValue = arr[i];
            int nowIndex = i;

            // 법위 밖 인덱스 제거
            if (!dq.isEmpty() && dq.peekFirst() <= i - L) {
                dq.removeFirst();
            }

            // deque를 이용한 정렬
            while(!dq.isEmpty() && arr[i] <= arr[dq.peekLast()]){
                dq.removeLast();
            }

            dq.addLast(nowIndex);
            sb.append(arr[dq.peekFirst()]).append(" ");
        }
    }

    public static void output() {
        System.out.print(sb.toString());
    }
}
