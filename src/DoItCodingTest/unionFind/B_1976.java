package DoItCodingTest.unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 여행 계획 짜기
 * */
public class B_1976 {
    public static int n, m;
    public static int[] arr;
    public static int[] answer;
    public static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        answer = new int[m];
        list = new ArrayList[n+1];
        arr = new int[n+1];

        for(int i = 0; i <= n; i++){
            arr[i] = i;
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i <= n; i++) {
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                if(i == j+1) continue;
                if(Integer.parseInt(str[j]) == 1) {
                    list[i].add(j+1);
                    list[j+1].add(i);
                    union(i, j+1);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int num = Integer.parseInt(st.nextToken());
            answer[i] = find(num);
        }

        int flag = answer[0];
        boolean flag2 = true;
        for(int i = 1; i < m; i++) {
            if(flag != answer[i]) {
                flag2 = false;
                break;
            }
        }

        String result = flag2 ? "YES" : "NO";
        System.out.print(result);
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
        else return arr[a] = find(arr[a]);
    }
}
