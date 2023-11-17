import java.io.*;
import java.util.*;

/**
* 문제해결
* 로봇 강아지 구현
* - 방향과 이동 거리를 입력으로 받음
* - 이동하기 전 공원을 벗어나는지 확인 => 장애물이 있으면 명령 무시
* - 이동하기 전 장애물 확인 => 장애물이 있으면 명령 무시
*
* 1. 지도 만들기
* 2. 시작점을 찾아서 로봇 강아지 놓기
* 3. 명령어를 받아서
* 4. 조건 확인 후 true면 이동
* 5. 모든 명령을 다 실행한 후 마지막 위치 return;
*/

class Solution {
    
    public static char[][] board;
    public static Dog dog;
    public static StringTokenizer st;
    
    public int[] solution(String[] park, String[] routes) {
        // 1. 지도 만들기 + 시작점에 강아지 위치
        makeBoard(park);
        
        // 2. 명령어를 받아서
        for(String comm : routes) {
            st = new StringTokenizer(comm, " ");
            String dir = st.nextToken();
            int dist = Integer.parseInt(st.nextToken());
            
            // 3. 조건 확인
            if(isInPark(dir, dist) && !isObstacle(dir, dist)) {
                dog.move(dir, dist);
            }
        }
        
        // 4. 답 return
        int[] answer = new int[2];
        answer[1] = dog.x;
        answer[0] = dog.y;
        return answer;
    }
    
    public void makeBoard(String[] park) {
        board = new char[park.length][park[0].length()];
        for(int i = 0; i < park.length; i++) {
            String str = park[i];
            for(int j = 0; j < park[0].length(); j++) {
                char ch = str.charAt(j);
                if(ch == 'S') dog = new Dog(j, i);
                board[i][j] = ch;
            }
        }
    }
    
    public boolean isInPark(String dir, int dist) {
        if(dir.equals("N") && dog.y - dist >= 0) return true;
        if(dir.equals("S") && dog.y + dist < board.length) return true;
        if(dir.equals("W") && dog.x - dist >= 0) return true;
        if(dir.equals("E") && dog.x + dist < board[0].length) return true;
        
        return false;
    }
    
    public boolean isObstacle(String dir, int dist) {
        if(dir.equals("N")) {
            for(int i = dog.y - dist; i <= dog.y; i++) {
                if(board[i][dog.x] == 'X') return true;
            }
        };
        if(dir.equals("S")) {
            for(int i = dog.y; i <= dog.y + dist; i++) {
                if(board[i][dog.x] == 'X') return true;
            }
        }
        if(dir.equals("W")) {
            for(int i = dog.x - dist; i <= dog.x; i++) {
                if(board[dog.y][i] == 'X') return true;
            }
        }
        if(dir.equals("E")) {
            for(int i = dog.x; i <= dog.x + dist; i++) {
                if(board[dog.y][i] == 'X') return true;
            }
        }
        
        return false;
    }
    
    
    
    static class Dog {
        int x, y;
        
        public Dog(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public void move(String dir, int dist) {
            if(dir.equals("N")) this.y -= dist;
            else if(dir.equals("S")) this.y += dist;
            else if(dir.equals("W")) this.x -= dist;
            else this.x += dist;
        }
    }
}