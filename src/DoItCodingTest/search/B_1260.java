package DoItCodingTest.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 / 실버 2 / DFS와 BFS 프로그램
 * */
public class B_1260 {
    static int N, M, V;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];

        list = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list[v1].add(v2);
            list[v2].add(v1);
        }

        for(int i = 1; i <= N; i++){
            Collections.sort(list[i]);
        }

        visited[V] = true;
        sb.append(V + " ");
        DFS(V);
        sb.append("\n");
        visited = new boolean[N+1];
        visited[V] = true;
        BFS(V);
        visited[V] = false;
        System.out.print(sb.toString());
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(node);

        while(!queue.isEmpty()){
            int now = queue.poll();
            sb.append(now + " ");
            for (int x : list[now]) {
                if(!visited[x]) {
                    visited[x] = true;
                    queue.offer(x);
                }
            }
        }
    }

    private static void DFS(int node) {
        for(int x : list[node]){
            if(!visited[x]) {
                visited[x] = true;
                sb.append(x + " ");
                DFS(x);
            }
        }
    }
}
