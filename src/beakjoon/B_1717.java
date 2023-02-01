package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1717 {

    public static int n, m;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for(int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int comm = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(comm == 0) {
                union(a, b);
            } else {
                int tmp1 = find(a);
                int tmp2 = find(b);
                String str = tmp1 == tmp2 ? "YES" : "NO";
                sb.append(str).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
    public static void union(int a, int b) {
        int tmp1 = find(a);
        int tmp2 = find(b);
        if(tmp1 > tmp2) {
            arr[tmp1] = tmp2;
        } else {
            arr[tmp2] = tmp1;
        }
    }
    public static int find(int a) {
        if(arr[a] == a) return a;
        else {
            return arr[a] = find(arr[a]);
        }
    }


}
