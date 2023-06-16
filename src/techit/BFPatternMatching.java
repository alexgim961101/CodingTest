package techit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BFPatternMatching {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String pattern = br.readLine();

        int tarIdx = 0;
        int patIdx = 0;

        while(tarIdx < target.length() && patIdx < pattern.length()) {
            if(target.charAt(tarIdx) != pattern.charAt(patIdx)) {
                tarIdx -= patIdx;
                patIdx = -1;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new BFPatternMatching().solution();
    }
}
