package inflearn.basic.StringSolution;

import java.io.*;
import java.util.*;

public class ReverseWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = null;

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

//        for(int i = 0; i < n; i++){
//            sb = new StringBuilder(br.readLine());
//            arr[i] = sb.reverse().toString();
//        }

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            int lt = 0;
            int rt = str.length() - 1;
            char[] ch = str.toCharArray();
            while(lt < rt) {
                char tmp = ch[rt];
                ch[rt] = ch[lt];
                ch[lt] = tmp;
                lt++;
                rt--;
            }
            System.out.println(String.valueOf(ch));
        }

//        for(int i = 0; i < n; i++){
//            System.out.println(arr[i]);
//        }
    }
}
