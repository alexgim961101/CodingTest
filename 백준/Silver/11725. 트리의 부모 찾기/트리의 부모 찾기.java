import java.util.*;
import java.io.*;
class Main {
    static int N;
    static int[] answer;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    public static void process() {
        DFS(1);
    }

    public static void DFS(int start) {
        visited[start] = true;

        for(int node : list[start]) {
            if(!visited[node]) {
                answer[node] = start;
                DFS(node);
            }
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        answer = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            list[node1].add(node2);
            list[node2].add(node1);
        }
    }

    public static void output() {
        for(int i = 2; i <= N; i++) {
            sb.append(answer[i] + "\n");
        }
        System.out.print(sb.toString());
    }
}