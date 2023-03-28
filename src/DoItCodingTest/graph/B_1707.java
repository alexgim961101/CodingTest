package DoItCodingTest.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 / 골드 4 / 이분 그래프
 * 핵심 -> 그래프에 사이클이 생기는지 판별할 것
 * ==> 지나가면서 1, -1로 체크
 * */
public class B_1707 {
    static int K, V, E;
    static ArrayList<Integer>[] lists;
    static int[] visited;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            flag = true;

            lists = new ArrayList[V+1];
            visited = new int[V+1];
            for(int i = 0; i <= V; i++){
                lists[i] = new ArrayList<>();
            }

            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());

                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                lists[v1].add(v2);
                lists[v2].add(v1);
            }

            for(int i = 1; i <= V; i++){
                if(visited[i] == 0) {
                    BFS(i, 1);
                }
                if(!flag) break;
            }
            System.out.println(flag ? "YES" : "NO");
        }
    }

    public static void BFS(int node, int color) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(node);
        visited[node] = color;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for(int next : lists[now]) {
                if(visited[next] == visited[now]) {
                    flag = false;
                    return;
                }
                if(visited[next] == 0) {
                    visited[next] = visited[now] * -1;
                    queue.offer(next);
                }
            }
        }
    }
}
