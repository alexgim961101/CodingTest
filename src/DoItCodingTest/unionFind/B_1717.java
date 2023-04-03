package DoItCodingTest.unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 / 골드 5 / 집합의 표현
 * */
public class B_1717 {
    static int N, M;
    static int[] set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        set = new int[N+1];
        for(int i = 0; i <= N; i++){
            set[i] = i;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());

            int a = find(num2);
            int b = find(num3);
            if(num1 == 0) {
                union(a, b);
            } else {
                String result = a == b ? "YES" : "NO";
                sb.append(result).append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    public static void union(int a, int b) {
        int tmp1 = find(a);
        int tmp2 = find(b);
        set[tmp2] = tmp1;
    }

    public static int find(int a) {
        if(set[a] == a) return set[a];
        else return set[a] = find(set[a]);
    }

}
