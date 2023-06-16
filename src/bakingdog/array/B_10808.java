package bakingdog.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 알파벳 개수 / 브론즈 4
 * */
public class B_10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        int[] arr = new int[26];

        for(char ch : str.toCharArray()) {
            int num = ch - 'a';
            arr[num]++;
        }

        for(int n : arr) {
            sb.append(n).append(" ");
        }

        System.out.print(sb.toString());


    }
}
