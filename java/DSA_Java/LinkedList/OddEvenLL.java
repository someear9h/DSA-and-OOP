package LinkedList;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class OddEvenLL {
    private static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        // Rearrange the list into odd and even nodes
        while (even != null && even.next != null) {
            odd.next = odd.next.next; // Link current odd to the next odd
            even.next = even.next.next; // Link current even to the next even

            odd = odd.next; // Move to the next odd
            even = even.next; // Move to the next even
        }

        // Attach the even list at the end of the odd list
        odd.next = evenHead;

        return head;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        head = oddEvenList(head);

        System.out.println("Modified List:");
        printList(head);
    }
}
