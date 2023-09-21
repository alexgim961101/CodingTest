package inflearn.basic.StringSolution;

import java.io.*;
import java.util.*;

public class SpecialWordReverse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        char[] ch = str.toCharArray();
        int lt = 0;
        int rt = ch.length - 1;
        while (lt < rt) {
            if(!Character.isAlphabetic(ch[lt])) lt++;
            else if (!Character.isAlphabetic(ch[rt])) rt--;
            else {
                char tmp = ch[rt];
                ch[rt] = ch[lt];
                ch[lt] = tmp;
                lt++;
                rt--;
            }
        }
        System.out.println(String.valueOf(ch));
    }
}
