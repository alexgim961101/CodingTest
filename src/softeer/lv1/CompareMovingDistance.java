package softeer.lv1;

import java.io.*;
import java.util.*;

public class CompareMovingDistance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(a > b ? "A" : (a == b ? "same" : "B"));
    }
}
