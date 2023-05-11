package DoItCodingTest.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 / 골드 5 / 최소비용 구하기
 * */
public class B_1916 {
    static int N, M, S, E;
    static boolean[] visited;
    static int[] dist;
    static ArrayList<Point>[] lists;
    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];

        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        lists = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            lists[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            lists[start].add(new Point(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


        // 2. 다익스트라 로직
        PriorityQueue<Point> pq = new PriorityQueue<>();
        dist[S] = 0;

        pq.add(new Point(S, 0));
        boolean flag = false;

        while (!pq.isEmpty()) {
            Point now = pq.poll();
            visited[now.v] = true;

            if(now.v == E) break;

            for(Point nv : lists[now.v]) {
                if(visited[nv.v]) continue;

                int newDist = now.w + nv.w;
                if(newDist < dist[nv.v]) {
                    dist[nv.v] = newDist;
                    pq.add(new Point(nv.v, newDist));
                }
            }
        }

        // 3. 출력
        System.out.println(dist[E]);
    }

    static class Point implements Comparable<Point>{
        int v;
        int w;

        public Point(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Point o) {
            return this.w - o.w;
        }
    }
}
