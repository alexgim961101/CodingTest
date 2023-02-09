package study;

/**
 * 멀리 뛰기 / Lv 2
 * dy[n] = n칸까지 갈수 있는 경우의 수
 * dy[n] = dy[n-1] + dy[n-2]
 * dy[1] = 1, dy[2] = 2;
 * */
public class FarJump {
    static long[] dy;
    public static long solution(int n){
        dy = new long[2001];

        dy[1] = 1;
        dy[2] = 2;

        for(int i = 3; i < 2001; i++){
            dy[i] = (dy[i-1] + dy[i-2]) % 1234567;
        }

        return dy[n];
    }
}
