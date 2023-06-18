package bakingdog.array;

import java.io.*;

/**
 * 방 번호 / 실버 5
 *
 * 해결 방법
 * 1). 0 ~ 9 끼지의 배열 생성
 * 2). 입력받은 숫자의 갯수를 배열에 저장
 * 3). 9랑 6은 모두 6으로 퉁치고 저징
 * 4). arr[6] != 0 && arr[6] % 2 == 0 이명 arr[6] /= 2 -> 9랑 6을 한번에 체크했기 때문에
 * 5). arr의 최댓값을 return
 * */
public class B_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[10];

        int num = Integer.parseInt(br.readLine());

        while(num > 0) {
            int tmp = num % 10;
            num /= 10;

            if(tmp == 6 || tmp == 9) arr[6]++;
            else arr[tmp]++;
        }

        if(arr[6] != 0) {
            arr[6] = (arr[6] / 2) + (arr[6] % 2);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 10; i++) {
            max = Math.max(arr[i], max);
        }

        bw.write(String.valueOf(max));

        bw.close();
        br.close();
    }
}
