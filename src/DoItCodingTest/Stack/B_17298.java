package DoItCodingTest.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 오큰수 / 골드 4 / 시간제한 1초 / 메모지 제한 512MB
 * */
public class B_17298 {
    static int n;
    static int[] arr;
    static int[] result;
    public static void main(String[] args) {
        input();
        process();
        output();
    }
    private static void process() {
        result[n-1] = -1;
        int max = arr[n-1];
        for(int i = n - 2; i >= 0; i--){

        }
    }


    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        try {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            result = new int[n];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
        } catch (IOException e) {
            return;
        }
    }

    private static void output() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(result[i]).append(" ");
        }
        System.out.print(sb.toString());
    }
}
