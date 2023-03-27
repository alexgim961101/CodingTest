package inflearn.graph;


import java.util.*;

public class First {
    int[] dist;
    boolean[] visited;
    ArrayList<Point>[] list;
    Queue<Point> queue;
    public int solution(int n, int[][] flights, int s, int e, int k){
        int answer = 0;

        dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        visited = new boolean[n];
        visited[s] = true;

        list = new ArrayList[n];
        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < flights.length; i++){
            list[flights[i][0]].add(new Point(flights[i][1], flights[i][2]));
        }

        queue = new LinkedList<>();
        queue.offer(new Point(s, 0));

        while (!queue.isEmpty() && k >= 0){
            k--;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Point now = queue.poll();
                for(Point node : list[now.dest]) {
                    int next = node.dest;
                    int newCost = node.weight + now.weight;
                    if(newCost < dist[next]) {
                        dist[next] = newCost;
                        queue.offer(new Point(next, newCost));
                    }
                }
            }
        }

        answer = dist[e] == Integer.MAX_VALUE ? -1 : dist[e];

        return answer;
    }

    public static void main(String[] args){
        First T = new First();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
    }

    static class Point {
        int dest;
        int weight;

        public Point(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
}
