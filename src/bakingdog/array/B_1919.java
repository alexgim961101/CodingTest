package bakingdog.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 애너그램 만들기 / 브론즈 2
 * */
public class B_1919 {
    static int cnt = 0;
    static int[][] arr = new int[2][26];
    static String[] strArr = new String[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 2; i++){
            strArr[i] = br.readLine();
        }

        for(int i = 0; i < 2; i++) {
            for (char ch : strArr[i].toCharArray()) {
                arr[i][ch - 'a']++;
            }
        }

        for(int i = 0; i < 26; i++) {
            cnt += Math.abs(arr[0][i] - arr[1][i]);
        }

        System.out.print(cnt);
    }
}
