package softeer.lv2;

import java.io.*;
import java.util.*;

public class EightStep {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[8];

        for(int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean asc = true;
        boolean desc = true;

        for(int i = 1; i < 8; i++) {
            if(arr[i - 1] < arr[i]) {
                desc = false;
                break;
            }
        }

        for(int i = 1; i < 8; i++) {
            if(arr[i - 1] > arr[i]) {
                asc = false;
                break;
            }
        }

        System.out.println(asc ? "ascending" : (desc ? "descending" : "mixed"));
    }
}
