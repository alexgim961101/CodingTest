package inflearn.extream.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PalindromCase {

    static Deque<Character> deque;
    static ArrayList<String> result;
    static Map<String, Integer> map;

    static String s;
    List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        deque = new LinkedList<>();
        result = new ArrayList<>();
        map = new HashMap<>();
    }

    public static void DFS() {
        
    }
}
