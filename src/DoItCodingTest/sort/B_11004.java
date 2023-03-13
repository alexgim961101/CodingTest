package DoItCodingTest.sort;

import java.io.*;
import java.util.StringTokenizer;

public class B_11004 {
    static int n, k;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(0, n - 1, k - 1);
        bw.append(String.valueOf(arr[k-1]));
        bw.flush();
        bw.close();
    }

    private static void quickSort(int start, int end, int k) {
        if(start < end) {
            int pivot = partition(start, end);
            if(pivot == k) return;
            else if (pivot < k) quickSort(pivot+1, end, k);
            else quickSort(start, pivot-1, k);
        }
    }

    private static int partition(int start, int end) {
        int mid = (start + end) / 2;
        swap(start, mid);
        int pivot = arr[start];

        int i = start + 1;
        int j = end;
        while (i < j) {
            while (pivot < arr[j]) i++;
            while (arr[j] > pivot) j--;

            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        int tmp = arr[i];
        arr[i] = pivot;
        arr[start] = tmp;
        return i;
    }

    private static void swap(int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }
}
