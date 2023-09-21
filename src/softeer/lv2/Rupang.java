package softeer.lv2;

import java.io.*;
import java.util.*;

public class Rupang {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int answer = 0;

        Gold[] g = new Gold[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            g[i] = new Gold(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(g);

        for(int i = 0; i < n; i++) {
            if(w == 0) break;
            if(g[i].m > w) {
                answer += w * g[i].p;
                w = 0;
            } else {
                answer += g[i].m * g[i].p;
                w -= g[i].m;
            }
        }

        System.out.println(answer);
    }

    static class Gold implements Comparable<Gold>{
        private int m;
        private int p;

        public Gold(int m, int p) {
            this.m = m;
            this.p = p;
        }

        @Override
        public int compareTo(Gold o) {
            return o.p - this.p;
        }
    }
}
