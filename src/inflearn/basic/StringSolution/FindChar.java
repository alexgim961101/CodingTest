package inflearn.basic.StringSolution;

import java.io.*;
import java.util.*;

public class FindChar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase();
        char find = br.readLine().toCharArray()[0];

        if(find >= 65 && find <= 90) find += 32;

        int cnt = 0;
        find = Character.toLowerCase(find);
//        for(char ch : str.toCharArray()) {
//            if(ch == find) cnt++;
//        }

        System.out.println(cnt);
    }
}
