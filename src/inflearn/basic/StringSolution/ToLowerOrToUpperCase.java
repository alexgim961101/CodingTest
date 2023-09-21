package inflearn.basic.StringSolution;

import java.io.*;
import java.util.*;
public class ToLowerOrToUpperCase {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        for(char ch : str.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                sb.append(Character.toLowerCase(ch));
            } else {
                sb.append(Character.toUpperCase(ch));
            }
        }

        System.out.println(sb.toString());
    }
}
