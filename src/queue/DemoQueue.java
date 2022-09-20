package queue;

class DQueue {
    int head = 0, tail = 0;
    int size = 0, len = 0;
    int[] arr;

    DQueue(int size) {
        arr = new int[size];
        len = arr.length;
    }

    public void enqueue(int data) {
        if (!isFull()) {
            arr[head % len] = data;
            head = (head % len) + 1;
            size++;
        } else {
            System.out.println("Queue is full");
        }
    }

    public int dequeue() {
        int data = -1;
        if (!isEmpty()) {
            data = arr[tail % len];
            tail = (tail % len) + 1;
            size--;
        } else {
            System.out.println("Queue is empty");
        }
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == len;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(" " + arr[(head + i) % len]);
        }
        System.out.println();
    }
}

public class DemoQueue {
    public static void main(String[] args) {
        DQueue dQueue = new DQueue(3);
        dQueue.enqueue(1);
        dQueue.enqueue(2);
        dQueue.enqueue(3);
        dQueue.enqueue(4);
        dQueue.display();
        dQueue.dequeue();
        dQueue.display();
        dQueue.enqueue(4);
        dQueue.enqueue(4);
        dQueue.display();
        dQueue.dequeue();
        dQueue.dequeue();
        dQueue.dequeue();
        dQueue.dequeue();
        dQueue.display();
    }
}
