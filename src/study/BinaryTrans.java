package study;

/**
 * 이진 변화 반복하기 / 프로그래머스
 * 문자열 x에서 0 제거
 * 그 후 x의 길이 c를 2진법으로 표현한 문자열로 변경
 * return [이진 변환의 회수, 제거된 0의 개수]
 *
 * 해결 방법
 * 1). 0이 제거된 문자열 x의 길이 -> 1의 갯수와 비슷
 * 2). 1의 갯수를 toBinaryString() 으로 이진 변환
 * 3). 반복
 * */
public class BinaryTrans {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(s.length() > 1){
            int oneCount = 0;

            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '1') oneCount++;
                else answer[1]++;
            }
            s = Integer.toBinaryString(oneCount);
            answer[0]++;
        }
        return answer;
    }
}
