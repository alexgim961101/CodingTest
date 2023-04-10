package study;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 / 단어 변환
 * 문제 요약 : begin의 문자열 -> target 문자열로 변환, 단 words의 단어로만 바꿀수 있다.
 * 해결 순서
 * 1). BFS를 이용
 * 2). check() 함수를 통해 begin 문자열과 words의 문자열을 비교해서 하나만 다른 경우 true 반환
 * 3). 하나만 다른 경우 queue에 저장
 * 4). 반복하면서 level 체크
 * 5). target과 똑같은 문자열이 나오면 break
 * 6). 체크한 level return
 * */
public class WordTransfrom {
    int level = 0;
    boolean flag = false;
    public int solution(String begin, String target, String[] words) {

        BFS(begin, target, words);

        return flag ? level : 0;
    }

    public void BFS(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for(int i = 0; i < size; i++){
                String nowStr = queue.poll();
                if(nowStr.equals(target)) {
                    flag = true;
                    return;
                }

                for(int j = 0; j < words.length; j++){
                    if(check(nowStr, words[j])) {
                        String nxtStr = words[j];
                        queue.offer(nxtStr);
                    }
                }
            }
            level++;

            if(level > words.length) break;
        }
    }

    public boolean check(String begin, String target) {
        int length = begin.length();

        int count = 0;
        for(int i = 0; i < length; i++){
            if(begin.charAt(i) != target.charAt(i)) count++;
            if(count > 1) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        WordTransfrom w = new WordTransfrom();
        System.out.print(w.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }
}