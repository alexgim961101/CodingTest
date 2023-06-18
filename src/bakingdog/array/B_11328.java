package bakingdog.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Strfry / 브론즈 2
 * */
public class B_11328 {
    static final String success = "Possible";
    static final String fail = "Impossible";
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            arr = new int[26];
            st = new StringTokenizer(br.readLine());

            String tmp1 = st.nextToken();
            String tmp2 = st.nextToken();

            if(tmp1.length() != tmp2.length()) sb.append(fail).append("\n");
            else {
                for(char ch : tmp1.toCharArray()) {
                    arr[(ch - 'a')]++;
                }

                boolean flag = true;
                for(char ch : tmp2.toCharArray()) {
                    int num = ch - 'a';
                    if(arr[num] == 0) {
                        flag = false;
                        break;
                    } else {
                        arr[num]--;
                    }
                }

                if(flag) sb.append(success).append("\n");
                else sb.append(fail).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
