import java.io.*;
import java.util.*;

/**
 * 문제해결
 *
 *
 * */
class Main {
    static int N;
    static int[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        tree = new int[26][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = st.nextToken().charAt(0) - 'A';

            String left = st.nextToken();
            String right = st.nextToken();

            tree[idx][0] = left.equals(".") ? -1 : left.charAt(0) - 'A';
            tree[idx][1] = right.equals(".") ? -1 : right.charAt(0) - 'A';
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);

    }

    public static void preOrder(int node) {
        if(node == -1) return;
        System.out.print((char) ('A' + node));
        preOrder(tree[node][0]);
        preOrder(tree[node][1]);
    }

    public static void inOrder(int node) {
        if(node == -1) return;
        inOrder(tree[node][0]);
        System.out.print((char) ('A' + node));
        inOrder(tree[node][1]);
    }

    public static void postOrder(int node) {
        if(node == -1) return;
        postOrder(tree[node][0]);
        postOrder(tree[node][1]);
        System.out.print((char) ('A' + node));
    }

}