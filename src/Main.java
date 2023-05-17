import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int x = 1;
        for(int i = 0; 3 * i < 10; i++) {
            if(i == 2) i = --i + 2 + x++;
            System.out.println(i);
        }
    }

}