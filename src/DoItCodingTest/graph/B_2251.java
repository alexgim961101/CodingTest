package DoItCodingTest.graph;

import java.io.*;
import java.util.*;

/**
 * 백준 / 물통 / 골드 5
 * */
public class B_2251 {
    static int[] start = {0, 0, 1, 1, 2, 2};
    static int[] end = {1, 2, 0, 2, 0, 1};
    static int[] mid = {2, 1, 2, 0, 1, 0};
    static boolean[][][] visited;
    static int A, B, C;
    static int[] cup = new int[3];        // A, B, C 를 저장하는 곳
    static int[] store = new int[3];      // 현재 물의 양을 기록하는 곳
    static Set<Integer> answerSet = new TreeSet<>();   // 값이 중복으로 들어오는 것을 방지하고 오름차순으로 출력하기 위해 treeSet 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        cup[0] = A;
        cup[1] = B;
        cup[2] = C;

        visited = new boolean[A+1][B+1][C+1];
        store = new int[3];

        store[2] = C;
        visited[0][0][C] = true;
        answerSet.add(C);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(store);

        while (!queue.isEmpty()) {
            int[] nowCup = queue.poll();

            for(int i = 0; i < 6; i++){
                int[] nextCup = new int[3];
                int startCup = nowCup[start[i]];              // 먼저 컵 하나를 잡는다.
                if(startCup == 0) continue;                   // 잡은 컵의 물이 0 이면 패스한다.
                int endCup = nowCup[end[i]];                  // 물을 보낼 대상을 정한다.
                int midCup = nowCup[mid[i]];                  // 움직임이 없는 컵

                if(endCup == cup[end[i]]) continue;           // 물을 보낼 대상이 다 차 있으면 패스한다.

                endCup += nowCup[start[i]];                   // 물을 보낸다.
                if(endCup > cup[end[i]]) {
                    int tmp = (endCup - cup[end[i]]);
                    startCup += tmp;
                    endCup -= tmp;
                }
                startCup -= nowCup[start[i]];

                nextCup[start[i]] = startCup;                   // 현재 물 상태 저장
                nextCup[end[i]] = endCup;
                nextCup[mid[i]] = midCup;

                if(visited[nextCup[0]][nextCup[1]][nextCup[2]]) continue;   // 현재 물 상태가 예전에도 있었으면 패스

                visited[nextCup[0]][nextCup[1]][nextCup[2]] = true;         // 예전에도 현재 물 상태는 없었기 때문에 현재 물 상태를 등록
                queue.offer(nextCup);

                if(nextCup[0] == 0) answerSet.add(nextCup[2]);
            }
        }

        Iterator<Integer> iter = answerSet.iterator();
        while (iter.hasNext()) bw.append(iter.next() + " ");
        bw.flush();
        bw.close();
    }
}
