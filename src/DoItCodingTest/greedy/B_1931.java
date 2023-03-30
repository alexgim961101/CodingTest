package DoItCodingTest.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 / 실버1 / 회의실 배정
 * 끝나는 시간으로 정렬 후 문제풀면 될듯?
 * */
public class B_1931 {
    static int N;
    static Conference[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        list = new Conference[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[i] = new Conference(start, end);
        }

        Arrays.sort(list);

        int count = 0;
        int preValue = -1;
        for(int i = 0; i < N; i++){
            int start = list[i].startTime;
            int end = list[i].endTime;

            if(preValue > start) continue;

            preValue = end;
            count++;
        }

        System.out.print(count);
    }

    static class Conference implements Comparable<Conference>{
        int startTime;
        int endTime;

        public Conference(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Conference o) {
            int dif = this.endTime - o.endTime;
            if(dif == 0) {
                return this.startTime - o.startTime;
            } else {
                return dif;
            }
        }
    }
}
