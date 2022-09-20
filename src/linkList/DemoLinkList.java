package linkList;

class Node {
    int data;
    Node next;

    Node() {
        this.data = 0;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class List {
    private Node head;

    public void add(int data) {
        Node cache = head;
        if (cache == null) {
            head = new Node(data, null);
        } else {
            while (cache.next != null) {
                cache = cache.next;
            }
            cache.next = new Node(data, null);
        }
    }

    public void addLast(int data) {
        add(data);
    }

    public void addFirst(int data) {
        Node cache = head;
        head = new Node(data, cache);
    }

    public void shiftHead() {
        Node cache = head;
        head = cache.next;
        cache.next = null;
        cache.data = 0;
    }

    public void insertAt(int data, int index) {
        Node cache = head;
        Node temp = head;
        int cnt = 0;
        while (cache.next != null && cnt != index) {
            cache = cache.next;
            cnt++;
            if (cnt > 1) {
                temp = temp.next;
            }
        }
        if (cnt == 0) {
            addFirst(data);
        } else if (cache.next == null && cnt < index) {
            cache.next = new Node(data, null);
        } else if (cnt == index) {
            temp.next = new Node(data, temp.next);
        } else {
            System.out.println("invalid pos");
        }
    }

    public void removeAt(int index) {
        Node cache = head;
        Node temp = head;
        int cnt = 0;
        while (cnt != index && cache.next != null) {
            cache = cache.next;
            cnt++;
            if (cnt > 1) {
                temp = temp.next;
            }
        }
        if (cnt == 0) {
            shiftHead();
        } else if (cnt == index) {
            Node del = temp.next;
            temp.next = temp.next.next;
            del.data = 0;
            del.next = null;
        } else if (cache.next == null) {
            Node del = temp.next;
            temp.next = null;
            del.data = 0;
            del.next = null;
        }
    }

    public void display() {
        Node cache = head;
        System.out.println();
        while (cache != null) {
            System.out.print(cache.data + "->");
            cache = cache.next;
        }
    }

    public List reverse(){
        Node cache = head;
        List rev = new List();
        while (cache != null){
            rev.addFirst(cache.data);
            cache = cache.next;
        }
        return  rev;
    }
}

public class DemoLinkList {
    public static void main(String[] args) {
        List lst = new List();
        lst.addFirst(1);
        lst.add(5);
        lst.add(6);
        lst.add(7);
        lst.add(8);
        lst.add(9);
        lst.display();
        lst.insertAt(10, 0);
        lst.display();
        lst.insertAt(11, 7);
        lst.display();
        lst.removeAt(7);
        lst.display();
        lst.removeAt(0);
        lst.display();
        lst.removeAt(1);
        lst.display();
        lst.removeAt(2);
        lst.display();
        List rev = lst.reverse();
        rev.display();
    }
}
