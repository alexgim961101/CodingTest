import java.io.*;
import java.util.*;

/**
* 문제해결
* 1). BFS를 이용 -> 섬에 있는 식량 파악
* 2). BFS 도중에 방문 체크
* 3). 이걸 2차원 배열을 돌면서 반복
* 4). 정렬 후 return
*/

class Solution {
    char[][] board;
    boolean[][] visited;
    List<Integer> result = new ArrayList<>();
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    
    public int[] solution(String[] maps) {
        input(maps);
        
        // 핵심 로직
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                if(board[i][j] != 'X' && !visited[i][j]) result.add(BFS(j, i));
            }
        }
        
        return output();
    }
    
    public int BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        int sum = board[y][x] - '0';
        
        q.offer(new int[] {x, y});
        visited[y][x] = true;
        
        while(!q.isEmpty()) {
            int[] node = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];
                
                if(nx < 0 || nx >= board[0].length || ny < 0 || ny >= board.length) continue;
                if(board[ny][nx] == 'X' || visited[ny][nx]) continue;
                
                q.offer(new int[] {nx, ny});
                sum += board[ny][nx] - '0';
                visited[ny][nx] = true;
            }
        }
        
        return sum;
    }
    
    public void input(String[] maps) {
        board = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++) {
            String str = maps[i];
            for(int j = 0; j < maps[0].length(); j++) {
                board[i][j] = str.charAt(j);
            }
        }
    }
    
    public int[] output() {
        if(result.size() == 0) return new int[] {-1};
        Collections.sort(result);
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}