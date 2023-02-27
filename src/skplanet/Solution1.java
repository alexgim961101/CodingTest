package skplanet;

import java.util.StringTokenizer;

/**
 * 빵 k개를 판매하려면 최소 몇분이 걸리는지 구하는 문제
 * 1. 시간 비교를 어떻게 할지
 * */
public class Solution1 {
    public int solution(String[] bakery_schedule, String current_time, int k){
        StringTokenizer st = null;
        boolean flag = false;
        int answer = 0;

        st = new StringTokenizer(current_time, ":");
        int curHour = Integer.parseInt(st.nextToken());
        int curMin = Integer.parseInt(st.nextToken());

        for(String str : bakery_schedule){
            st = new StringTokenizer(str, " ");

            // 시각과 빵의 개수 구분
            String time = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            // 시각을 시간과 분으로 구분
            st = new StringTokenizer(time, ":");
            int hour = Integer.parseInt(st.nextToken());
            int min = Integer.parseInt(st.nextToken());

            if(curHour > hour) continue;
            else if(curHour == hour) {
                if(curMin > min) continue;
            }

            k = k - num;
            if(k <= 0) {
                answer += (hour - curHour) * 60 + (min - curMin);
                flag = true;
                break;
            }

        }

        return flag ? answer : -1;
    }
}
