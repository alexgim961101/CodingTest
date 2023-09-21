package inflearn.basic.StringSolution;

import java.io.*;
import java.util.*;

public class DuplicateStrRm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(i == str.indexOf(ch)) sb.append(ch);
        }

        System.out.println(sb.toString());
    }
}
