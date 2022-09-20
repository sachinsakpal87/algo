package bst;

import java.util.Stack;

class Node {
    int data;
    Node left, right;

    Node() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class Bst {
    Node root;

    public void insert(int data) {
        root = insert(data, root);
    }

    private Node insert(int data, Node root) {
        if (root == null) {
            root = new Node(data, null, null);
        } else {
            if (data < root.data) {
                root.left = insert(data, root.left);
            } else {
                root.right = insert(data, root.right);
            }
        }
        return root;
    }

    public boolean search(int val) {
        return search(val, root);
    }

    private boolean search(int val, Node root) {
        if (root == null) {
            return false;
        }
        if (root.data == val) {
            return true;
        } else {
            if (val < root.data) {
                return search(val, root.left);
            } else {
                return search(val, root.right);
            }
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + "->");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + "->");
        inOrder(root.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + "->");
    }

    public void mirror() {
        root = mirror(root);
    }

    private Node mirror(Node root) {
        if (root == null)
            return root;
        Node left = mirror(root.left);
        Node right = mirror(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    public void flatten() {
        Node cache = root;
        Stack<Node> stack = new Stack();
        while (cache != null || !stack.isEmpty()) {
            if (cache.right != null) {
                stack.push(cache.right);
            }
            if (cache.left != null) {
                cache.right = cache.left;
                cache.left = null;
            } else if (!stack.isEmpty()) {
                cache.right = stack.pop();
            }
            cache = cache.right;
        }
    }
}

public class DemoBST {
    public static void main(String[] args) {
        Bst obj = new Bst();
        obj.insert(5);
        obj.insert(6);
        obj.insert(3);
        obj.insert(9);
        obj.insert(10);
        obj.insert(12);
        obj.insert(1);
        System.out.println(obj.search(11));
        System.out.println();
        obj.preOrder();
        System.out.println();
        obj.inOrder();
        System.out.println();
        obj.postOrder();
        System.out.println();
        obj.mirror();
        obj.inOrder();
    }
}

