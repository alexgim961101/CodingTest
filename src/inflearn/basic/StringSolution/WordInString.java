package inflearn.basic.StringSolution;

import java.io.*;
import java.util.*;

public class WordInString {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int idx = 0;
        int length = Integer.MIN_VALUE;

        for(int i = 0; i < str.length; i++){
            if(str[i].length() > length) {
                idx = i;
                length = str[i].length();
            }
        }

        System.out.println(str[idx]);
    }
}
