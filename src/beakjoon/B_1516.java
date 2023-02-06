package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 1. 입력
 * - N : 건물 종류 수 = 입력 라인 수 (1부터 시작)
 * - ArrayList<Integer> list[N + 1] : 각 리스트의 0번째는 건물을 짓는데 걸리는 시간, 그 후에는 필요한 건물들
 * - degree[] : 위상정렬응 이용하기 위한 배열
 * 2. 출력
 * - answer[N+1] : 각 건물별 완성 시간
 * */


public class B_1516 {

    public static int N;
    public static ArrayList<Integer>[] list;
    public static int[] degree;
    public static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        degree = new int[N+1];
        answer = new int[N+1];

        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            while(true) {
                int tmp = Integer.parseInt(st.nextToken());
            }
        }
    }
}
