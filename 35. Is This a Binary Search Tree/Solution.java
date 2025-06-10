import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Solution {
    public static boolean checkBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.data <= min || node.data >= max) {
            return false;
        }
        return isBST(node.left, min, node.data) && isBST(node.right, node.data, max);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node root = null;
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            Node newNode = new Node(data);
            if (root == null) {
                root = newNode;
            } else {
                Node parent = queue.peek();
                if (parent.left == null) {
                    parent.left = newNode;
                } else {
                    parent.right = newNode;
                    queue.poll();
                }
            }
            queue.add(newNode);
        }
        System.out.println(checkBST(root) ? "Yes" : "No");
    }
}