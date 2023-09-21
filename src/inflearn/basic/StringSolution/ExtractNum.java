package inflearn.basic.StringSolution;

import java.io.*;
import java.util.*;

public class ExtractNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        for(char ch : str.toCharArray()) {
            if(Character.isDigit(ch)) sb.append(ch);
        }

        int answer = Integer.parseInt(sb.toString());
        System.out.println(answer);
    }
}
