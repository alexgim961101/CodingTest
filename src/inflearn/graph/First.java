package inflearn.graph;


import java.util.*;

public class First {
    public int solution(int n, int[][] flights, int s, int e, int k){
        int answer = 0;

        ArrayList<Area>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }

        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);

        for(int i = 0; i < flights.length; i++){
            int start = flights[i][0];
            int end = flights[i][1];
            int cost = flights[i][2];

            list[start].add(new Area(end, cost));
        }

        Queue<Area> queue = new LinkedList<>();
        queue.offer(new Area(s, 0));
        costs[s] = 0;
        int L = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Area now = queue.poll();

                for (Area nx : list[now.dest]) {
                    int endPont = nx.dest;
                    int endCost = nx.cost;

                    if (now.cost + endCost < costs[endPont]) {
                        costs[endPont] = now.cost + endCost;
                        queue.offer(new Area(endPont, costs[endPont]));
                    }
                }
            }
            L++;
            if(L > k) break;
        }

        answer = costs[e] == Integer.MAX_VALUE ? -1 : costs[e];

        return answer;
    }

    public static void main(String[] args){
        First T = new First();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
    }

    static class Area {
        int dest;
        int cost;

        public Area(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}
