package inflearn.basic.dp;

import java.io.*;
import java.util.*;

public class PutTop {
    static int N;
    static Brick[] arr;
    static int[] dy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        arr = new Brick[N];
        dy = new int[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Brick(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);

        dy[0] = arr[0].h;
        int answer = dy[0];
        for(int i = 1; i < N; i++) {
            int maxH = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(arr[i].w < arr[j].w && dy[j] > maxH) maxH = dy[j];
            }
            dy[i] = maxH + arr[i].h;
            answer = Math.max(answer, dy[i]);
        }

        System.out.println(answer);
    }

    static class Brick implements Comparable<Brick>{
        public int s, h, w;

        public Brick(int s, int h, int w) {
            this.s = s;
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Brick o) {
            return o.s - this.s;
        }
    }
}
