import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = i;
        }

        int count = 1;
        int start = 1;
        int end = 1;
        int sum = 1;

        while(end != n){
            if(sum == n){
                count++;
                end++;
                sum += arr[end];
            }else if(sum > n){
                sum -= arr[start];
                start++;
            }else{
                end++;
                sum += arr[end];
            }
        }

        System.out.println(count);

    }
}
