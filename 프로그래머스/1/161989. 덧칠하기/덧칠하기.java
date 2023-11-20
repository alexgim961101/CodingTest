import java.io.*;
import java.util.*;

/**
* 문제 해결
*
* 1). 벽의 구역을 나타낼 배열 생성
* 2). 색칠할 공간과 아닌 공간을 구분해둘 것
* 3). 색칠할 공간의 수 저장
* 4). 제일 왼쪽부터 색칠해야하는 공간 색칠 -> 이때 룰러의 왼쪽 끝을 색칠할 공간에 맞추기
* 5). 룰러가 벽의 범위를 넘을 경우 왼쪽으로 한칸씩 범위가 맞을 때까지 이동
* 6). 다음 번 색칠 시, 룰러 범위 이후의 범위를 색틸
* 7). 5) 반복
* 8). 색칠할때마자 색칠한 공간 수-- -> 0이 되면 모든 공간 색칠
* 9). 색칠한 획수 return
*/

class Solution {
    boolean[] wall;
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        wall = new boolean[n + 1];
        for(int x : section) wall[x] = true;
        
        int start = section[0];
        int end = section[section.length - 1];
        
        int val = start;
        for(int x : section) {
            if(val > x) continue;
            if(val < x) val = x;
            answer++;
            val += m;
        }
        
        return answer;
    }
    
    public boolean check(int start, int end) {
        for(int i = start; i <= end; i++) {
            if(wall[i]) return false;
        }
        return true;
    }
}