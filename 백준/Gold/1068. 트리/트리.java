import java.io.*;
import java.util.*;

class Main{
    static int N, root, deleteNode, count;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        input();
        if(root == deleteNode) System.out.println(0);
        else {
            DFS(root);
            System.out.println(count);
        }
    }

    public static void DFS(int node) {
        if(tree[node].size() == 0 || (tree[node].size() == 1 && tree[node].get(0) == deleteNode)) count++;
        for(int nn : tree[node]) {
            if(nn == deleteNode) continue;
            DFS(nn);
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        count = 0;
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int node = Integer.parseInt(st.nextToken());

            if(node != -1) {
                tree[node].add(i);
            } else {
                root = i;
            }
        }

        deleteNode = Integer.parseInt(br.readLine());
    }
}