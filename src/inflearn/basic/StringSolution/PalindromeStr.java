package inflearn.basic.StringSolution;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class PalindromeStr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();

        int lt = 0;
        int rt = str.length() - 1;

        boolean flag = true;

        char[] arr = str.toCharArray();
        while (lt < rt) {
            if(arr[lt] == arr[rt]) {
                lt++;
                rt--;
            } else {
                flag = false;
                break;
            }
        }
        /**
         * String tmp = new StringBuilder(str).reverse() 한 후 비교해도 좋음
         * tmp.equalsIgnoreCase(str);
         * */

        System.out.println(flag ? "YES" : "NO");

    }
}
