package inflearn.basic.dp;

import java.io.*;
import java.util.*;

// dp 1강 계단 오르기
/**
 * dy[n] = dy[n-1] + dy[n-2];
 * 초기값 : dy[1] = 1, dy[2] = 2;
 * */
public class UpStair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dy = new int[n+1];

        dy[1] = 1;
        dy[2] = 2;

        for(int i = 3; i <= n; i++){
            dy[i] = dy[i-1] + dy[i-2];
        }

        System.out.println(dy[n]);
    }
}
