import java.io.*;
import java.util.*;

public class Solution {

    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < q; i++) {
            String[] query = scanner.nextLine().split(" ");
            int type = Integer.parseInt(query[0]);

            switch (type) {
                case 1:
                    int x = Integer.parseInt(query[1]);
                    enqueue(x);
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    printFront();
                    break;
            }
        }
        scanner.close();
    }

    private static void enqueue(int x) {
        stack1.push(x);
    }

    private static void dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        stack2.pop();
    }

    private static void printFront() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        System.out.println(stack2.peek());
    }
}
