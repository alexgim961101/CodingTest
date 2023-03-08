package programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 프로그래머스 / Lv.2 / 튜플
 * 문제 요약
 * - 튜플을 나타내는 집합이 주어질 때, 해당 집합이 무슨 튜플을 나타내는지 return
 *
 * 문제 해결 방법
 * 1). 주어진 문자열을 잘 처리하여 배열로 만든다.
 * 2). 문자열 배열의 각 value의 길이를 측정해 오름차순으로 정렬
 * 3). 각 value의 마지막 값을 최종 리턴값에 추가
 * */
public class Tuple {
    public int[] solution(String s) {
        s = s.substring(2, s.length());
        s = s.substring(0, s.length()-2).replace("},{", "-");

        String[] arr = s.split("-");

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };

        Arrays.sort(arr, comparator);

        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < arr.length; i++){
            String[] tmp = arr[i].split(",");
            for(int j = 0; j < tmp.length; j++){
                int value = Integer.parseInt(tmp[j]);
                if(!list.contains(value)) list.add(value);
            }
        }

        int[] answer = new int[arr.length];
        int idx = 0;
        for(int x : list) {
            answer[idx] = x;
            idx++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Tuple t = new Tuple();
        System.out.print(t.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
    }
}
