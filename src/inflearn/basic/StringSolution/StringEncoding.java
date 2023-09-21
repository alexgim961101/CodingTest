package inflearn.basic.StringSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringEncoding {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        char[] ch = str.toCharArray();
        char pre = ch[0];
        int cnt = 1;
        for(int i = 1; i < ch.length; i++){
            char now = ch[i];
            if(pre == now) {
                cnt++;
            } else {
                if(cnt == 1) {
                    sb.append(pre);
                } else {
                    sb.append(pre).append(cnt);
                }
                cnt = 1;
                pre = now;
            }
        }

        if(cnt == 1) {
            sb.append(pre);
        } else {
            sb.append(pre).append(cnt);
        }

        System.out.println(sb.toString());
    }
}
