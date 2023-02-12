package programmers.springIntern;

import java.util.HashMap;
import java.util.Map;

/**
 * 복권 문제
 * 1. 당첨자 수 >= 구매한 사람 수 => 구매한 사람 모두 당첨
 * 2. 당점자 수 < 구매한 사람 수 => 무작위로 당첨자 수 만큼 정해짐
 * 문제 조건
 * 1). 당첨 확률이 가장 높은 복권 -> 당첨자 수 / 구매한 사람수 가 높아야됨
 * 2). 확률이 비슷할 경우 당첨금액이 가장 높은 것 선택
 * lotteries = {당첨자 수, 구매한 사람 수, 당첨 금액}
 * 해결 과정
 * - 반복문을 이용하여 당첨 확률(당첨자 수 / 구매한 사람수) 가 가장 높은 idx를 선택
 * - 복수가 될 수 있으니 Map에 저장 (Key : idx / value : 당첨금)
 * - map을 탐색하면서 value가 가장 높을때의 key를 구해서 key+1 return;
 * - 주의 사항 : 100% 그 이상은 없다.
 * */
public class Lotto {
    public int solution(int[][] lotteries) {
        int answer = 0;
        int length = lotteries.length;

        Map<Integer, Integer> map = new HashMap<>();

        double max = -1;
        int maxIdx = -1;
        for(int i = 0; i < length; i++){
            int tmp1 = lotteries[i][0];
            int tmp2 = lotteries[i][1] + 1;
            double per = (double) tmp1 / tmp2;
            if(per >= 1) per = 100;
            if(max < per) {
                max = per;
                maxIdx = i;
            }
        }

        for(int i = 0; i < length; i++){
            int tmp1 = lotteries[i][0];
            int tmp2 = lotteries[i][1] + 1;
            double per = (double) tmp1 / tmp2;
            if(per >= 1) per = 100;
            if(max == per) map.put(i, lotteries[i][2]);
        }

        int maxValue = -1;
        maxIdx = -1;
        for (Map.Entry<Integer, Integer> entrySet : map.entrySet()){
            int value = entrySet.getValue();
            if(value > maxValue) {
                maxValue = value;
                maxIdx = entrySet.getKey();
            }
        }
        answer = maxIdx+1;
        return answer;
    }

    public static void main(String[] args) {
        Lotto l = new Lotto();
        System.out.println(l.solution(new int[][] {{100, 90, 500}, {1000, 90, 100}}));
    }
}
