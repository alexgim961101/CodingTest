package study;

import java.io.*;
import java.util.*;

/**
 * 해결 방법
 * 1). 최상단, 최하단, 양 옆 끝을 파악
 * 2).(가장 위, 가장 왼쪽, 가장 아래, 가장 오른쪽)
 * */
public class ClearBackground {
    static int l, r, h, d;
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        l = Integer.MAX_VALUE;
        r = -1;
        h = Integer.MAX_VALUE;
        d = -1;

        for(int i = 0; i < wallpaper.length; i++) {
            char[] str = wallpaper[i].toCharArray();
            for(int j = 0; j < str.length; j++) {
                if(str[j] == '#') {
                    if(h > i) h = i;
                    if(d < i) d = i;
                    if(l > j) l = j;
                    if(r < j) r = j;
                }
            }
        }

        answer[0] = l;
        answer[1] = h;
        answer[2] = d + 1;
        answer[3] = r + 1;

        return answer;
    }

    public static void main(String[] args) {
        ClearBackground c = new ClearBackground();
        System.out.println(c.solution(new String[]{".#...", "..#..", "...#."}));
    }
}
