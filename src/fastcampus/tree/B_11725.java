package fastcampus.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_11725 {
    static int N;
    static ArrayList<Integer>[] lists;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        lists = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lists[a].add(b);
            lists[b].add(a);
        }

        bfs(1, -1);

        for(int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void bfs(int value, int par) {
        for(int x : lists[value]) {
            if(x == par) continue;
            parent[x] = value;
            bfs(x, value);
        }
    }
}
