import java.io.*;
import java.util.*;

abstract class Node implements Comparable<Node> {
    public int frequency;
    public char data;
    public Node left, right;
    
    public Node(int freq) { 
        frequency = freq; 
    }
    
    public int compareTo(Node tree) {
        return frequency - tree.frequency;
    }
}

class HuffmanLeaf extends Node {
    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
}

class HuffmanNode extends Node {
    public HuffmanNode(Node l, Node r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}

class Solution {
    public static String decode_huff(Node root, String s) {
        StringBuilder result = new StringBuilder();
        Node current = root;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                current = current.left;
            } else {
                current = current.right;
            }
            
            if (current.left == null && current.right == null) {
                result.append(current.data);
                current = root;
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        System.out.println(a);
    }
}