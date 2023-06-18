package bakingdog.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 두 수의 합 / 실버 3
 *
 * 해결 방법
 * 1). 입력 받은 배열을 오름차순으로 정렬
 * 2). 투 포인터를 이용하여 lp = 0, rp = arr.length - 1 부터 시작
 * 3). 투 포인터의 합이 x 보다 크면 rp--;
 * 4). 투 포인터의 합이 x랑 같으면 lp++, rp--; (n개의 서로 다른 양수 이기 때문에 가능), count++;
 * 5). 투 포인터의 합이 x 보다 작으면 lp++;
 * 6). lp > rp이면 종료
 * */
public class B_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lp = 0;
        int rp = n - 1;
        int cnt = 0;

        while(lp < rp) {
            int sum = arr[lp] + arr[rp];
            if(sum > x) rp--;
            else if(sum < x) lp++;
            else {
                lp++;
                rp--;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
