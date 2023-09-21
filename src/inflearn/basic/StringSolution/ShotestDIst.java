package inflearn.basic.StringSolution;

import java.io.*;
import java.util.*;

public class ShotestDIst {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        char t = st.nextToken().charAt(0);

        char[] ch = s.toCharArray();
        int[] answer = new int[ch.length];

        int p = 1000;
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == t) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }

        p = 1000;
        for(int i = ch.length - 1; i >= 0; i--) {
            if(ch[i] == t) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }

        for(int i = 0; i < answer.length; i++){
            System.out.print(answer[i] + " ");
        }
    }
}
