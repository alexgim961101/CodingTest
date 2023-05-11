package DoItCodingTest.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/***
 * 실버 2 / 트리의 부모 찾기 / 11725
 */
public class B_11725 {
    static int N;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        parent = new int[N+1];

        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            list[num1].add(num2);
            list[num2].add(num1);
        }

        DFS(1);

        for(int i = 2; i <= N; i++){
            System.out.println(parent[i]);
        }
    }

    public static void DFS(int node) {
        for(int nv : list[node]) {
            if(!visited[nv]) {
                visited[nv] = true;
                parent[nv] = node;
                DFS(nv);
                visited[nv] = false;
            }
        }
    }
}
