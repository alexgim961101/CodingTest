package study;

/**
 * 정수 삼각형 / Lv 3
 * dy[n][k] : n층까지 거쳐간 숫자의 합
 * dy[n][k] = max(max(dy[n-1][k-1], dy[n-1][k]) + 현재값, dy[n][k]);
 * answer = Math.max(dy[n][0] ~ dy[n][n])
 * 단, 예외 조건 존재
 * => 삼각형의 가장 왼쪽 변과 오른쪽 변은 각각 (왼쪽 변)dy[n][k] = dy[n-1][k] + 현재값,  (오른쪽 변)dy[n][k] = dy[n-1][k-1] + 현재값 이다.
 * */
public class IntTriangle {
    public int solution(int[][] triangle){
        int answer = Integer.MIN_VALUE;
        int height = triangle.length;
        int[][] dy = new int[height][height];

        dy[0][0] = triangle[0][0];

        for(int i = 1; i < height; i++){
            for(int j = 0; j < triangle[i].length; j++){
                if(j == 0) {
                    dy[i][j] = dy[i-1][j] + triangle[i][j];
                } else if (j == triangle[i].length-1) {
                    dy[i][j] = dy[i-1][j-1] + triangle[i][j];
                } else {
                    dy[i][j] = Math.max(Math.max(dy[i-1][j-1], dy[i-1][j]) + triangle[i][j], dy[i][j]);
                }
            }
        }

        // 최댓값 구하기
        for(int i = 0; i < triangle.length; i++){
            answer = Math.max(answer, dy[height-1][i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        IntTriangle intTriangle = new IntTriangle();
        System.out.println(intTriangle.solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}
