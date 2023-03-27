package DoItCodingTest.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 / 효율적인 해킹 / 실버 1
 * */
public class B_1325 {
    static int N, M, count;
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    static int[] node;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        node = new int[N+1];

        lists = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            lists[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            lists[v1].add(v2);
        }

        for(int i = 1; i <= N; i++){
            visited = new boolean[N+1];
            BFS(i);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++){
            max = Math.max(max, node[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            if(node[i] == max) sb.append(i + " ");
        }
        System.out.print(sb.toString());

    }

    public static void BFS(int vxt){
        Queue<Integer> queue = new LinkedList<>();
        visited[vxt] = true;
        queue.offer(vxt);

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int nx : lists[now]) {
                if(!visited[nx]) {
                    visited[nx] = true;
                    node[nx]++;
                    queue.offer(nx);
                }
            }
        }
    }

}
