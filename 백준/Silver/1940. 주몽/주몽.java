import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = n-1;
        int count = 0;

        while(start < end){
            int sum = arr[start] + arr[end];
            if(sum == m){
                count++;
                start++;
                end--;
            }else if(sum > m){
                end--;
            }else{
                start++;
            }
        }
        System.out.println(count);
    }
}
