package LinkedList;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteMidNodeBF {

    private static Node deleteMiddle(Node head) {
        // Base case: if the linked list is empty or has only one node
        if (head == null || head.next == null) {
            return null;
        }

        // Count the number of nodes in the linked list
        Node temp = head;
        int n = 0;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // Calculate the index of the middle node (0-based index)
        int index = n / 2;

        // Traverse to the node just before the middle node
        temp = head;
        while (index > 1) { // Stop one node before the middle
            temp = temp.next;
            index--;
        }

        // Remove the middle node
        temp.next = temp.next.next;

        return head;
    }

    static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating a sample linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Display the original linked list
        System.out.print("Original Linked List: ");
        printLL(head);

        // Deleting the middle node
        head = deleteMiddle(head);

        // Displaying the updated linked list
        System.out.print("Updated Linked List: ");
        printLL(head);
    }
}


/*
 * You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.

For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 

Example 1:


Input: head = [1,3,4,7,1,2,6]
Output: [1,3,4,1,2,6]
Explanation:
The above figure represents the given linked list. The indices of the nodes are written below.
Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
We return the new list after removing this node. 

 */
