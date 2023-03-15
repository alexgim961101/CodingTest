package DoItCodingTest.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 / 골드 5 / ABCDE
 * */
public class B_13023 {
    static int N, M;
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lists = new ArrayList[N];
        for(int i = 0; i < N; i++){
            lists[i] = new ArrayList<>();
        }


        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            lists[n1].add(n2);
            lists[n2].add(n1);
        }

        for(int i = 0; i < N; i++){
            if(flag) break;
            visited = new boolean[N];
            visited[i] = true;
            DFS(i, 0);
        }

        int answer = flag ? 1 : 0;
        System.out.print(answer);
    }

    private static void DFS(int node, int depth) {
        if(depth == 4) {
            flag = true;
            return;
        } else {
            for(int x : lists[node]) {
                if(!visited[x]) {
                    visited[x] = true;
                    DFS(x, depth+1);
                    visited[x] = false;
                }
            }
        }
    }
}
