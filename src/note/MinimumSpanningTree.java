package note;

/**
 * 최소 신장 트리
 * 정의 : 가중치 무방향 그래프에서 모든 정점을 최소 비용으로 연결할 수 있는 방법
 * 종류 : Kruskal(간선 기준), Prim(정점 기준)
 * 조건 1 : 최소비용이 되려면 사이클이 형성되면 안됨 -> 즉, 간선의 수 = (정점의 수 - 1)개 일때 최소비용을 가짐
 * 조건 2 : 하나의 그래프는 MST가 하나 이상 존재할 수 있다.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 크루스칼 알고리즘
 * https://sskl660.tistory.com/72
 * 시간복잡도 : O(ElogV) -> 사실상 간선 연결 정보를 정렬하는데 걸리는 시간복잡도와 비슷
 * 1. 간선을 비용 기준으로 오름차순 정렬
 * 2. 정렬된 순서대로 간선 선택
 * 3. 간선의 양 끝 정점을 Union, 이때 두 정점이 같은 집합에 속해있다면 사이클이 발생한다고 판단 -> UnionX
 * 4. 반복
 * */
class Kruskal {
    int V, E;           // V : 정점 ,  E : 간선
    int[][] graph;      // 간선의 연결 정보를 담고 있는 2차원 배열  (정점1, 정점2, 연결비용)
    int[] parent;      // Union-find 알고리즘에서 사용할 각 노드의 부모
    int final_cost;     // 최종적으로 연결된 MST 비용
/*
    sample input(첫 줄의 첫 숫자는 정점의 개수, 두 번째 숫자는 간선의 개수).
    6 9
    1 6 5
    2 4 6
    1 2 7
    3 5 15
    5 6 9
    3 4 10
    1 3 11
    2 3 3
    4 5 7
 */
    public void process() throws IOException {
        // 1. 입력 부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());      // 정접의 수 입력
        E = Integer.parseInt(st.nextToken());      // 간선의 수 입력
        final_cost = 0;                            // MST 비용 초기화
        
        // 2. 간선 연결 정보 저장
        graph = new int[E][3];                     // 각 간선마다 (시작 정점, 끝 정점, 연결비용) 저장
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());    // 시작 정점 저장
            graph[i][1] = Integer.parseInt(st.nextToken());    // 끝 정점 저장
            graph[i][2] = Integer.parseInt(st.nextToken());    // 연결 비용 저장
        }

        // 3. 간선 비용을 기준으로 오름차순 정렬
        Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        // 4. 부모 노드 정보 생성
        parent = new int[V];
        for(int i = 0; i < V; i++){
            parent[i] = i;                   // 초기 상태는 누구와도 연결되어 있지 않기 때문에 자기 자신이 부모이다.
        }

        // 5. 크루스칼 알고리즘 진행
        for(int i = 0; i < E; i++) {         // 위에서 간선 연결 정보(graph)를 오름차순 정렬했기 때문에 graph배열에서 순서대로 뽑아내기만 하면 됨
            if(find(graph[i][0]) != find(graph[i][1])){     // 사이클이 존재하는지 판단
                union(graph[i][0], graph[i][1]);            // 간선 연결
                final_cost += graph[i][2];                  // MST 비용 계산
            }
        }
    }

    // 아래 2개의 메서드는 유니온 파인드 알고리즘을 구현한 것
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a > b) parent[a] = b;
        else parent[b] = a;
    }
    
    public int find(int a) {
        if(a == parent[a]) return a;
        else {
            return parent[a] = find(parent[a]);
        }
    }
}


/**
 * 프림 알고리즘
 * */
class Prim {
    
}

public class MinimumSpanningTree {
    public static void main(String[] args) {

    }
}
