package toss;
/**
 * 멋쟁이 팬디지털
 * 1).
 * */
public class first {
    public int solution(String s, int N) {
        int answer = -1;

        for(int i = 0; i <= s.length() - N; i++){
            String tmp = s.substring(i, i + N);
            if(check(tmp, N)) answer = Math.max(answer, Integer.parseInt(tmp));
        }

        return answer == -1 ? -1 : answer;
    }

    // 조건 : 1부터 N까지의 숫자를 하나씩 사용하여 만든 숫자
    public boolean check(String substring, int N) {
        boolean[] checked = new boolean[N+1];
        for(int i = 1; i <= N; i++){
            checked[i] = true;
        }

        for(char x : substring.toCharArray()) {
            int num = x - '0';
            if(num <= N && checked[num]) checked[num] = false;
            else return false;
        }

        return true;
    }

    public static void main(String[] args) {
    }
}
