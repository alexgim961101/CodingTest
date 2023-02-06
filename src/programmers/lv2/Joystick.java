package programmers.lv2;

// a b c d e f g h i  j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z
// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26

/**
 * 그리디 : 탐욕법 (https://school.programmers.co.kr/learn/courses/30/lessons/42860)
 * 1. 특정 알파벳 - A 가 13 이하면 커서를 위로 올리고 아니면 커서를 밑으로 내림
 * 2. 중간에 A가 나올 경우, 뒤로 가야할지 앞으로 가야할지 결정해야됨
 * */
public class Joystick {
    public int solution(String name) {
        int answer = 0;
        int move = name.length()-1;
        
        for(int i = 0; i < name.length(); i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            int next = i + 1;
            while(next < name.length() && name.charAt(next) == 'A'){
                next++;
            }
            move = Math.min(move, i*2 + name.length()-next);
            move = Math.min(move, (name.length() - next) * 2 + i);
        }
        
        return answer + move;
    }
}
