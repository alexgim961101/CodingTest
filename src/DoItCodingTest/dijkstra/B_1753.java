package DoItCodingTest.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 / 최단 경로 / 골드 4
 *
 * 해결 방법
 * -> 전형적인 다익스트라 문제
 * */
public class B_1753 {

    static  int V, E, start;
    static ArrayList<Point>[] lists;
    static boolean[] visited;
    static int[] dist;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 입력 부분
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());

        lists = new ArrayList[V+1];
        for(int i = 0; i <= V; i++){
            lists[i] = new ArrayList<>();
        }

        visited = new boolean[V+1];

        dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            lists[u].add(new Point(v, w));
        }

        // 2. 다익스트라 시작
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(start, 0));

        while (!pq.isEmpty()) {
            Point now = pq.poll();
            visited[now.vtx] = true;

            for(Point nv : lists[now.vtx]) {
                if(!visited[nv.vtx]) {
                    int newDist = dist[now.vtx] + nv.weight;
                    if(dist[nv.vtx] > newDist) {
                        dist[nv.vtx] = newDist;
                        pq.add(new Point(nv.vtx, newDist));
                    }
                }
            }
        }

        // 3, 출력
        for(int i = 1; i <= V; i++) {
            if(i == start) System.out.println(0);
            else if (dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }

    static class Point implements Comparable<Point>{
        int vtx;
        int weight;

        public Point(int vtx, int weight) {
            this.vtx = vtx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point o) {
            return this.weight - o.weight;
        }
    }
}
