package fastcampus.tree;

import java.io.*;
import java.util.*;

public class B_1068 {
    static int N;
    static ArrayList<Integer>[] child;
    static int[] leaf;
    static int erased;
    static int root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        child = new ArrayList[N];
        leaf = new int[N];

        for(int i = 0; i < N; i++) {
            child[i] = new ArrayList();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int par = Integer.parseInt(st.nextToken());
            if(par == -1) {
                root = i;
                continue;
            }
            child[par].add(i);
        }
        erased = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            if(child[i].contains(erased)) {
                child[i].remove(child[i].indexOf(erased));
                break;
            }
        }

        if(root != erased) bfs(root);
        System.out.println(leaf[root]);
    }

    public static void bfs(int node) {
        if(child[node].size() == 0) {
            leaf[node] = 1;
        } else {
            for(int n : child[node]) {
                bfs(n);
                leaf[node] += leaf[n];
            }
        }

    }
}
