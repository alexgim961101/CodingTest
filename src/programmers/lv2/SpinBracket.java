package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/76502  (괄호 회전하기)
 * Lv.2
 *
 * 풀이 방법
 * 1). stack을 이용 -> 괄호 검사기를 만듬
 * 2). 문자열을 왼쪽으로 회전시키면서 괄호 검사기로 옳바른지 판단
 * 3). 올바른 괄호면 answer++;
 * 
 * 주의사항
 * - 괄호 검사 시, 마지막에 ( or { or [ 등의 여는 괄호가 나타날 수 있으니 로직 끝에서 다시한번 체크해줘야 됨
 * */

public class SpinBracket {

    public boolean check(Queue<Character> queue) {
        Stack<Character> stk = new Stack<>();

        for(char x : queue) {
            if(x == '(' || x == '{' || x == '[') {
                stk.push(x);
            } else {
                if(stk.isEmpty()) return false;
                if(x == ')') {
                    if(stk.peek() == '(') stk.pop();
                    else return false;
                }
                if(x == '}') {
                    if(stk.peek() == '{') stk.pop();
                    else return false;
                }
                if(x == ']') {
                    if(stk.peek() == '[') stk.pop();
                    else return false;
                }
            }
        }

        if(!stk.isEmpty()) return false;

        return true;
    }

    public int solution(String s) {
        int answer = 0;

        Queue<Character> queue = new LinkedList<>();
        for(char ch : s.toCharArray()) {
            queue.add(ch);
        }

        answer = check(queue) ? answer+1 : answer;

        for(int i = 1; i < s.length(); i++) {
            queue.add(queue.poll());
            answer = check(queue) ? answer+1 : answer;
        }

        return answer;
    }
}
