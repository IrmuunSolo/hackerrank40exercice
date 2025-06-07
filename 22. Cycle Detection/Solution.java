import java.io.*;
import java.util.*;

public class Solution {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null) {
            return false;
        }
        
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        
        for (int t = 0; t < tests; t++) {
            int index = scanner.nextInt();
            
            int nodeCount = scanner.nextInt();
            SinglyLinkedListNode head = new SinglyLinkedListNode(scanner.nextInt());
            SinglyLinkedListNode current = head;
            SinglyLinkedListNode cycleNode = null;
            
            for (int i = 1; i < nodeCount; i++) {
                current.next = new SinglyLinkedListNode(scanner.nextInt());
                current = current.next;
                if (i == index) {
                    cycleNode = current;
                }
            }
            
            if (index >= 0 && cycleNode != null) {
                current.next = cycleNode;
            }
            
            System.out.println(hasCycle(head) ? 1 : 0);
        }
        
        scanner.close();
    }
}
