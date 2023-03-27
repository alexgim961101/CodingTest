package DoItCodingTest.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 백준 / 특정 거리의 도시 찾기 / 실버 2
 * */
public class B_18352 {
    static int N, M, K, X;
    static ArrayList<Integer>[] lists;
    static int[] dist;
    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        lists = new ArrayList[N+1];

        for(int i = 0; i <= N; i++){
            lists[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            lists[v1].add(v2);
        }

        dist[X] = 0;
        DFS(X, 1);

        Collections.sort(answer);

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i = 1; i <= N; i++){
            if(dist[i] == K) {
                sb.append(i+"\n");
                flag = true;
            }
        }

        System.out.print(!flag ? -1 : sb.toString());
    }

    public static void DFS(int start, int depth) {
        if(depth > K) {
            return;
        } else {
            for(int node : lists[start]){
                if(dist[node] > depth) {
                    dist[node] = depth;
                    DFS(node, depth+1);
                }
            }
        }
    }
}
