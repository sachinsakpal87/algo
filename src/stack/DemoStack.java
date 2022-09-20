package stack;

class DStack {
    int arr[];
    int size = 0;
    int head = 0;

    DStack(int size) {
        arr = new int[size];
    }

    public void push(int a) {
        if (!isFull()) {
            arr[head] = a;
            head++;
            size++;
        } else {
            System.out.println("Stack is full");
        }
    }

    public int pop() {
        int val = -1;
        if (!isEmpty()) {
            head--;
            size --;
            val = arr[head];
            arr[head] = 0;
        } else {
            System.out.println("Stack is empty");
        }
        return val;
    }

    public int peek() {
        int val = -1;
        if (!isEmpty()) {
            head--;
            val = arr[head];
            head++;
        } else {
            System.out.println("Stack is empty");
        }
        return val;
    }

    public void display() {
        for (int i=0; i< size; i++){
            System.out.print(arr[i]+"->");
        }
    }

    public boolean isFull() {
        return size == arr.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

public class DemoStack {
    public static void main(String[] args) {
        DStack dStack = new DStack(3);
        dStack.push(5);
        dStack.push(6);
        dStack.push(7);
        dStack.push(8);
        dStack.display();
        System.out.println("\n"+dStack.peek());
        System.out.println(dStack.pop());
        dStack.push(15);
        dStack.display();
        System.out.println();
        System.out.println(dStack.pop());
        System.out.println(dStack.pop());
        System.out.println(dStack.pop());
        System.out.println(dStack.pop());
    }
}
