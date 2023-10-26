import java.io.*;
import java.util.*;

class Main{
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Node root = new Node(new Node[26], false);
        while (N-- > 0) {
            String str = br.readLine();

            Node now = root;
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(now.text[ch - 'a'] == null) {
                    now.text[ch - 'a'] = new Node(new Node[26], false);
                }
                now = now.text[ch - 'a'];

                if(i == str.length() - 1) now.isEnd = true;
            }
        }

        int count = 0;
        while (M-- > 0) {
            String str = br.readLine();

            Node now = root;
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(now.text[ch - 'a'] == null) break;
                now = now.text[ch - 'a'];
                if(i == str.length() - 1 && now.isEnd) count++;
            }
        }

        System.out.println(count);

    }

    static class Node {
        Node[] text;
        boolean isEnd;

        public Node(Node[] text, boolean isEnd) {
            this.text = text;
            this.isEnd = isEnd;
        }
    }
}