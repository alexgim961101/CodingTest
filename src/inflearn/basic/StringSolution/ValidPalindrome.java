package inflearn.basic.StringSolution;

import java.io.*;
import java.util.*;

public class ValidPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuffer(str).reverse().toString();

        if(str.equals(tmp)) System.out.println("YES");
        else System.out.println("NO");
    }
}
