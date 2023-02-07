package codePlus.basic.DynamicProgramming;

public class FibocacciImpl {
    int[] dy = new int[101];    // Memoization을 하기 위한 배열
    
    // Top-down 방식
    int fibonacciRec(int n){
        if(n <= 1){
            return n;
        } else {
            if(dy[n] > 0) return dy[n];                    // Memoization에 의해 기록된 적이 있으면 바로 리턴
            dy[n] = fibonacciRec(n-1) + fibonacciRec(n-2); // 없으면 기록 후 리턴
            return dy[n];
        }

    }

    // Bottom-up 방식
    int fibonacciIter(int n){
        dy[0] = 1;
        dy[1] = 1;
        for(int i = 2; i <= n; i++){
            dy[i] = dy[i-1] + dy[i-2];
        }
        return dy[n];
    }

}
