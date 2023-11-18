import java.io.*;
import java.util.*;

/**
* 문제 해결
* 
* 1). 
*/

class Solution {
    public int solution(int [][]board) {
        int[][] dy = new int[board.length][board[0].length];
        int maxSquare = 0;
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] != 1) continue;
                if(i == 0 || j == 0) dy[i][j] = 1;
                else {
                    dy[i][j] = 1 + Math.min(Math.min(dy[i][j - 1], dy[i - 1][j]), dy[i - 1][j - 1]);
                }
                maxSquare = Math.max(maxSquare, dy[i][j]);
            }
        }
        
        return maxSquare * maxSquare;
    }
}