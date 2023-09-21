package inflearn.basic.dp;

import java.io.*;
import java.util.*;

public class LIS {
    static int N, answer;
    static int[] arr;
    static int[] dy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dy = new int[N];
        answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dy[0] = 1;

        for(int i = 1; i < N; i++){
            int max = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(arr[i] > arr[j] && dy[j] > max) max = dy[j];
            }
            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);
        }

        System.out.println(answer);
    }
}
