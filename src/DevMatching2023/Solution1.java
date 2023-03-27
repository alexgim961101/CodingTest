package DevMatching2023;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution1 {
    // 각 벽돌을 도식화한 배열
    int[][] board;

    public int[][] solution(String[] wall) {
        // 층 마다 벽돌의 구역을 지정
        // 먼저 한 층에 길이가 몇인지 알아야 함
        StringTokenizer st = new StringTokenizer(wall[0]);
        int sum = 0;  // 가로 길이를 나타낼 변수
        while (st.hasMoreTokens()){
            sum += Integer.parseInt(st.nextToken());
        }
        int idx = 0;
        board = new int[wall.length][sum];
        for(int i = 0; i < wall.length; i++){
            st = new StringTokenizer(wall[i]);
            for(int j = 0; j < sum; j++){
                int num = Integer.parseInt(st.nextToken());
                int end = j + num;
                int tmp = j;
                for(int k = tmp; k < end; k++){
                    board[i][k] = idx;
                    j++;
                }
                j--;
                idx++;
            }
        }

        // 층마다 인접 블록 수 계산 (최댓값 저장)
        // 0층 or 마지막 층은 윗층 or 아랫층만 존재하기 때문에 따로 처리
        // 제일 외쪽과 제일 오른쪽도 한 쪽 옆만 존재하기 때문에 예외 처리 해줘야 함
        int max = Integer.MIN_VALUE;     // 인접 블록 수의 최댓값 저장
        ArrayList<Point> points = new ArrayList<>();  // 최댓값일 때 좌표 저장
        for(int i = 0; i < wall.length; i++) {
            int blockCount = 0;
            // 0층 일때
            if (i == 0) {
                for (int j = 0; j < sum; j++) {
                    int count = 2;
                    if (j - 1 < 0) count--;
                    int blockIdx = board[i][j];
                    int tmp = board[i + 1][j];
                    count++;
                    while (j != sum && board[i][j] == blockIdx) {
                        if (tmp != board[i + 1][j]) count++;
                        j++;
                    }
                    j--;
                    if (j + 1 == sum) count--;

                    if (max < count) {
                        max = count;
                        points.clear();
                        points.add(new Point(blockCount, i));
                    } else if (max == count) {
                        points.add(new Point(blockCount, i));
                    }
                    blockCount++;
                }
            }
            // 마지막 층일 때
            else if (i == (wall.length - 1)) {
                for (int j = 0; j < sum; j++) {
                    int count = 2;
                    if (j - 1 < 0) count--;
                    int blockIdx = board[i][j];
                    int tmp = board[i - 1][j];
                    count++;
                    while (j != sum && board[i][j] == blockIdx) {
                        if (tmp != board[i - 1][j]) count++;
                        j++;
                    }
                    j--;
                    if (j + 1 == sum) count--;

                    if (max < count) {
                        max = count;
                        points.clear();
                        points.add(new Point(blockCount, i));
                    } else if (max == count) {
                        points.add(new Point(blockCount, i));
                    }
                    blockCount++;
                }
            }
            // 중간 층일 때
            else {
                for (int j = 0; j < sum; j++) {
                    int count = 2;
                    if (j - 1 < 0) count--;
                    int blockIdx = board[i][j];
                    int upTmp = board[i + 1][j];
                    int downTmp = board[i - 1][j];
                    count += 2;
                    while (j != sum && board[i][j] == blockIdx) {
                        if (upTmp != board[i + 1][j]) count++;
                        if (downTmp != board[i - 1][j]) count++;
                        j++;
                    }
                    j--;
                    if (j + 1 == sum) count--;

                    if (max < count) {
                        max = count;
                        points.clear();
                        points.add(new Point(blockCount, i));
                    } else if (max == count) {
                        points.add(new Point(blockCount, i));
                    }
                    blockCount++;
                }
            }
        }

        int[][] answer = new int[points.size()][2];
        for(int i = 0; i < points.size(); i++){
            Point p = points.get(i);
            answer[i][0] = p.y;
            answer[i][1] = p.x;
            System.out.print("[ " + p.y + " " + p.x + " ]");
        }
        return answer;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.solution(new String[]{"1 1", "1 1"}));
    }
}
