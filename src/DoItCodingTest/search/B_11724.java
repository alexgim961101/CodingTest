package DoItCodingTest.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 / 실버 2 / 연결 요소의 개수
 * */
public class B_11724 {
    static int N, M, answer;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;

        list = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            list[i] = new ArrayList();
        }

        visited = new boolean[N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list[v1].add(v2);
            list[v2].add(v1);
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]) {
                answer++;
                visited[i] = true;
                DFS(i);
            }
        }

        System.out.print(answer);
    }

    public static void DFS(int node) {
        for(int x : list[node]) {
            if(!visited[x]) {
                visited[x] = true;
                DFS(x);
            }
        }
    }
}
