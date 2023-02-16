package study;


/**
 * 숫자 게임 / 프로그래머스
 *
 * 해결 방법
 * 1). 어차피 B팀원의 순서를 ㅇ미의로 정할 수 있다 -> 순서가 상관 없다는 이야가
 * 2). A, B 배열을 오름차순으로 정렬
 * 3). 두 배열을 비교하면서 B배열이 크면 승점 1점씩 추가
 * ==> 예외 존재
 * ex A[5,2,3,7,90] B[1,2,3,8,12]
 * 정렬 => A[2,3,5,7,90] B[1,2,3,8,12]  ==> 이대로 비교하는 것보다 차라리 B의 12와 A의 2와 비교하는게 더 좋음
 *
 * 해결 방법 (dfs)
 * 1). 전체 탐색 이용(dfs)
 * 2). 최대 승점 출력
 * */
public class NumberGame {
    int answer;
    static boolean[] visited;
    public int solution(int[] A, int[] B) {
        answer = Integer.MIN_VALUE;
        for(int i = 0; i < B.length; i++){
            int sum = 0;
            visited = new boolean[B.length];
            visited[i] = true;
            if(A[0] < B[i]) sum++;
            DFS(1, A, B, sum);
        }
        return answer;
    }

    public void DFS(int depth, int[] A, int[] B, int sum){
        if(depth == B.length) {
            answer = Math.max(answer, sum);
        } else {
            for(int i = 0; i < B.length; i++){
                if(!visited[i]) {
                    visited[i] = true;
                    if(A[depth] < B[i]) sum++;
                    DFS(depth+1, A, B, sum);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberGame n = new NumberGame();
        System.out.print(n.solution(new int[]{5,1,3,7}, new int[]{2,2,6,8}));
    }
}
