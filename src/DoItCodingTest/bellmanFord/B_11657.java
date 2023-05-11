package DoItCodingTest.bellmanFord;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 / 골드 4 / 타임 머신
 * */
public class B_11657 {
    static int N, M;
    static ArrayList<Point>[] lists;
    static long[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lists = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            lists[i] = new ArrayList<>();
        }

        dist = new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            lists[a].add(new Point(b, c));
        }

        if(bf(1)) bw.append("-1");
        else {
            for(int i = 2; i <= N; i++) {
                if(dist[i] == Long.MAX_VALUE) bw.append("-1\n");
                else bw.append(String.valueOf(dist[i]) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }

    public static boolean bf(int start) {
        dist[start] = 0;
        boolean flag = false;     // 업데이트 유무 확인

        for(int i = 0; i < N-1; i++){
            flag = false;
            for(int j = 1; j <= N; j++){
                for(Point nv : lists[j]){
                    if(dist[j] == Long.MAX_VALUE) break;
                    if(dist[nv.v] > dist[j] + nv.w){
                        dist[nv.v] = dist[j] + nv.w;
                        flag = true;
                    }
                }
            }

            if(!flag) break;
        }

        if(flag) {
            for(int i = 1; i <= N; i++){
                for(Point nv : lists[i]){
                    if(dist[i] == Long.MAX_VALUE) break;
                    if(dist[nv.v] > dist[i] + nv.w){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static class Point {
        int v;
        int w;

        public Point(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
