package bakingdog.array;

import java.io.*;

/**
 * 숫자의 개수 / 브론즈 2
 * */
public class B_2577 {
    static int[] arr;
    static int cal = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new int[10];

        for(int i = 0; i < 3; i++) {
            cal *= Integer.parseInt(br.readLine());
        }

        while(cal > 0) {
            int num = cal % 10;
            cal /= 10;

            arr[num]++;
        }

        for(int i = 0; i < 10; i++) {
            bw.append(arr[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
