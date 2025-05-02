
package DS;
/*
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListCycleDetection {

    public static boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false; // No cycle if the list is empty or has only one node.
        }

        Node slow = head; // Slow pointer
        Node fast = head; // Fast pointer

        while (fast != null && fast.next != null) {
            slow = slow.next;           // Move slow pointer one step
            fast = fast.next.next;      // Move fast pointer two steps

            if (slow == fast) {         // Cycle detected
                return true;
            }
        }

        return false; // No cycle
    }

    public static void main(String[] args) {
        // Example usage
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // Create a cycle for testing
        head.next.next.next.next = head.next; // 4 -> 2 (cycle)

        System.out.println("Cycle present: " + hasCycle(head)); // Output: true
    }
}

*/