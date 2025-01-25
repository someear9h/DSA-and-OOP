// Check if a Linked List contains a cycle (loop).

package LinkedList;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class CycleDetectionLL {
    private static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next; // move one step 
            fast = fast.next.next; // move two steps

            if(slow == fast) {
                // there is a cycle
                return true;
            }
        }
        return false; // no cycle detected
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head; // creates a cycle

        System.out.println("Result is " + hasCycle(head));
    }
}

