package inflearn.basic.StringSolution;

import java.io.*;
import java.util.*;

public class SecretString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        String binaryString = changeBinary(str);

        String[] binary = new String[n];
        for(int i = 0; i < n; i++){
            binary[i] = binaryString.substring(i * 7, 7 * (i + 1));
            sb.append((char) Integer.parseInt(binary[i], 2));
        }

        System.out.println(sb.toString());
    }
    public static String changeBinary(String str) {
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()) {
            if(ch == '#') sb.append(1);
            else sb.append(0);
        }
        return sb.toString();
    }
}
