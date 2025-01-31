/*
 * *** Abdul Shad / 272 ***
 *
 * Homework # 1 (Programming Assignment). This Java class defines some basic
 * manipulation operations on Linked-Lists and Stacks.
 *
 * Additionally, there are two algorithm analysis methods where you need
 * to return a specified number as provided in comments of each method indicating
 * the complexity of the code shown. The testing routine will be looking for a
 * specific number returned.
 */

import java.util.Stack;

public class HW1 {

    static class LinkedList {
        static class Node {
            int data;
            Node next;

            Node(int d) {
                data = d;
                next = null;
            }
        }

        Node head;

        public void sortedInsert(int data) {
            Node new_node = new Node(data);
            new_node.next = null;

            // If the list is empty or new value is smaller, insert at head.
            if (this.head == null || head.data >= new_node.data) {
                new_node.next = head;
                head = new_node;
            } else {
                Node current = this.head;
                // Find the correct position to insert
                while (current.next != null && current.next.data < data) {
                    current = current.next;
                }
                new_node.next = current.next;
                current.next = new_node;
            }
        }

        public void removeElementsLT(int ltValue) {
            // Remove nodes from the head if they are less than ltValue
            while (head != null && head.data < ltValue) {
                head = head.next;
            }

            Node current = head;
            while (current != null && current.next != null) {
                // Skip nodes that are less than ltValue
                if (current.next.data < ltValue) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
        }

        public void removeElement(int value) {
            // Remove nodes from the head if they match value
            while (head != null && head.data == value) {
                head = head.next;
            }

            Node current = head;
            while (current != null && current.next != null) {
                // Skip nodes that match value
                if (current.next.data == value) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
        }

        public String toString() {
            StringBuilder output = new StringBuilder("[");
            Node currNode = this.head;
            while (currNode != null) {
                output.append(currNode.data).append(" ");
                currNode = currNode.next;
            }
            return output.toString().trim() + "]";
        }
    }

    static class Stacks {
        public static boolean isPalindrome(String input) {
            Stack<Character> stack = new Stack<>();
            input = input.toLowerCase().replaceAll("\\s+", ""); // Remove spaces and make lowercase

            // Push all characters onto the stack
            for (char ch : input.toCharArray()) {
                stack.push(ch);
            }

            // Compare characters in reverse order
            for (char ch : input.toCharArray()) {
                if (stack.pop() != ch) {
                    return false;
                }
            }
            return true;
        }

        public static int findLargestK(Stack<Integer> stack, int k) {
            Stack<Integer> tempStack = new Stack<>();
            int maxIndex = -1;
            int currentIndex = 0;

            // Go through the stack and find the largest index of k
            while (!stack.isEmpty()) {
                int val = stack.pop();
                if (val == k) {
                    maxIndex = currentIndex;
                }
                tempStack.push(val);
                currentIndex++;
            }

            // Put elements back into the original stack
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }

            return maxIndex;
        }
    }

    public static int algorithmAnalysis1(int n, int m) {
        int a = 0, b = 0;

        for (int i = 0; i < n; i++)
            a += Math.random();

        for (int j = 0; j < m; j++)
            b += Math.random();

        return 3; // The correct answer is O(N + M) time, O(1) space
    }

    public static int algorithmAnalysis2(int n) {
        int i, j, k = 0;
        for (i = n / 2; i <= n; i++)
            for (j = 2; j <= n; j = j * 2)
                k += n / 2;

        return 2; // The correct answer is O(N log N) time
    }
}
