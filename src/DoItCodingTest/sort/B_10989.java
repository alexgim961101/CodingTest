package DoItCodingTest.sort;

import java.io.*;

/**
 * 백준 / 수 정렬하기 3 / 실버 3
 * */
public class B_10989 {
    static int N;
    static int[] arr;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        nums = new int[10001];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            nums[arr[i]]++;
        }

        for(int i = 0; i < 10001; i++){
            if(nums[i] > 0){
                while (nums[i] != 0) {
                    bw.append(i+"\n");
                    nums[i]--;
                }
            }
        }
        bw.flush();
        bw.close();

    }
}
