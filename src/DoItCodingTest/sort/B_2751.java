package DoItCodingTest.sort;

import java.io.*;

/**
 * 백준 / 실버 5 / 수 정렬하기 2
 * */
public class B_2751 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, n-1);
        for(int i = 0; i < n; i++){
            bw.append(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void mergeSort(int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private static void merge(int left, int mid, int right) {
        int[] tmp = new int[right-left+1];   // 이 부분 중요
        int i = left;
        int j = mid + 1;
        int idx = 0;

        while(i <= mid && j <= right) {
            if(arr[i] < arr[j]) tmp[idx++] = arr[i++];
            else tmp[idx++] = arr[j++];
        }

        while(i <= mid) tmp[idx++] = arr[i++];
        while (j <= right) tmp[idx++] = arr[j++];

        int x = 0;
        for(int k = left; k <= right; k++){
            arr[k] = tmp[x++];
        }
    }
}
