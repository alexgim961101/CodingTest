import java.util.*;
import java.io.*;

/**
* 문제 해결
*
* 1). 두 배열을 모두 정렬
* 2). A배열 0번째와 B배열의 0번째를 비교
* 3). 
 * */
public class Solution {
    int answer = 0;
    
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIdx = 0;
        int bIdx = 0;
        
        while(true) {
            if(aIdx >= A.length || bIdx >= B.length) break;
            
            if(A[aIdx] >= B[bIdx]) {
                bIdx++;
            } else {
                bIdx++;
                aIdx++;
                answer++;
            }
        }
        
        return answer;
    }
}
