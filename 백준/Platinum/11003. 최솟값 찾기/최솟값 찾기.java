import java.io.*;
import java.util.*;

class Node{
    int index;
    int value;

    public Node() {
    }

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Deque<Node> deque = new LinkedList<>();

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            int now = Integer.parseInt(st.nextToken());

            while(!deque.isEmpty() && deque.getLast().value > now){
                deque.removeLast();
            }
            deque.addLast(new Node(i, now));
            if(deque.getFirst().index <= i-l) deque.removeFirst();

            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();

    }
}
