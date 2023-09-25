import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;
        for(int i = 0; i < n; i++){
            int start = 0;
            int end = n - 1;
            while(start < end){
                if(arr[i] == arr[start] + arr[end]){
                    if(start != i && end != i){
                        count++;
                        break;
                    }else if(start == i){
                        start++;
                    }else if(end == i){
                        end--;
                    }
                }else if(arr[i] > arr[start] + arr[end]){
                    start++;
                }else{
                    end--;
                }
            }
        }

        System.out.println(count);
    }
}
