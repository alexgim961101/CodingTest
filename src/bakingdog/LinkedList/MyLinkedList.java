package bakingdog.LinkedList;

public class MyLinkedList {
    private Node start;

    public void add(int data) {
        if(start == null) start = new Node(data);
        else {
            Node head = start;
            while(head.link != null) {
                head = head.link;
            }
            head.link = new Node(data);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node head = start;
        while(head != null) {
            sb.append(head.data);
            if(head.link != null) {
                sb.append(", ");
            }
            head = head.link;
        }

        sb.append("]");

        return sb.toString();
    }

    public int remove(int idx) {
        int i = 0;
        Node prev = start;
        Node head = start;
        while(i < idx) {
            prev = head;
            head = head.link;
            i++;
        }

        prev.link = head.link;

        return head.data;
    }


    private static class Node {
        private int data;
        private Node link;

        public Node(int data) {
            this.data = data;
        }
        public Node(int data, Node link) {
            this.data = data;
            this.link = link;
        }
    }
}
