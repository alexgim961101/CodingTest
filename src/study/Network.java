package study;


import java.util.ArrayList;

/**
 * 프로그래머스 / 네트워크
 * 문제 요약 : 네트워크의 갯수 구하기 (독림된 그래프의 수 구하기)
 *
 * 해결 순서
 * 1). 입력 정보를 ArrayList로 저장하기
 * 2). visited 배열 생성 -> 방문한 노드를 테크하기 위해서
 * 3). 0번 노드부터 반복하며 DFS 실행
 * 4). 반복문을 돌면서 visited[i]가 true 인 노드 i는 패스
 * 5). 이런식으로 반복문을 돌면서 갯수 체크
 * */
public class Network {
    boolean[] visited;
    ArrayList<Integer>[] lists;
    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];
        lists = new ArrayList[n];

        for(int i = 0; i < n; i++){
            lists[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(computers[i][j] == 1) {
                    lists[i].add(j);
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            answer++;
            DFS(i);
        }

        return answer;
    }

    public void DFS(int node) {
        for(int x : lists[node]) {
            if(!visited[x]) {
                visited[x] = true;
                DFS(x);
            }
        }
    }


    public static void main(String[] args) {
        Network n = new Network();
        System.out.print(n.solution(3, new int[][]{{1,1,0}, {1,1,1}, {0,1,1}}));
    }
}
