package bakingdog.queue;

/**
 * 큐 구현
 * */
public class QueueImpl {
    private final int size = 4;
    private final int offset = size + 1;
    private final int[] arr = new int[size + 1];
    private int front = 0;
    private int rear = 0;

    public QueueImpl() {
    }

    public void enQueue(int x) {
        if((rear+1) % (size + 1) == front) throw new RuntimeException("queue is full");
        rear = ++rear % offset;
        arr[rear] = x;
    }

    public int deQueue() {
        if(front == rear) throw new RuntimeException("queue is empty");

        front = ++front % offset;
        return arr[front];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public int peek() {
        if(isEmpty()) throw new RuntimeException("queue is empty");

        return arr[front + 1];
    }
}
