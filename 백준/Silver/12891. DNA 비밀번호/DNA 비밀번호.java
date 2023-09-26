import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * DNA 비밀번호 / 실버 2/ 시간 제한 2초 / 메모리  제한 512MB
 * 특정 구간에서 조건을 만족하는 문자열의 갯수 찾기 -> 특정 구간 => 슬라이딩 윈도우
 *
 * 해결 순서
 * 1). P를 이용해 구간의 크기 지정
 * 2). 해당 구간 내의 문자열이 조건에 맞는지 체크
 * 2-1). 조건 검사시 HashMap 사용
 * 3). 구간의 크기 P를 유지한 체 옆으로 한칸씩 이동
 * */
public class Main {
    static long S, P, count;
    static String str;
    static long[] acgt;
    public static void main(String[] args) {
        input();
        process();
        output();
    }

    private static void process() {
        Map<Character, Integer> map = new HashMap<>();

        long left = 0;
        long right = P-1;
        for(int i = (int)left; i <= right; i++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        if(check(map)) count++;

        left++;
        right++;
        while (right < S){
            map.put(str.charAt((int)(left-1)), map.get(str.charAt((int)(left-1))) - 1);
            map.put(str.charAt((int)right), map.getOrDefault(str.charAt((int)right), 0) + 1);
            if(check(map)) count++;
            left++;
            right++;
        }
    }

    private static boolean check(Map<Character, Integer> map) {
        if(map.getOrDefault('A', 0) < acgt[0]) return false;
        if(map.getOrDefault('C', 0) < acgt[1]) return false;
        if(map.getOrDefault('G', 0) < acgt[2]) return false;
        if(map.getOrDefault('T', 0) < acgt[3]) return false;
        return true;
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = 0;
        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            S = Long.parseLong(st.nextToken());
            P = Long.parseLong(st.nextToken());

            str = br.readLine();

            acgt = new long[4];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < 4; i++){
                acgt[i] = Long.parseLong(st.nextToken());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void output() {
        System.out.print(count);
    }
}
