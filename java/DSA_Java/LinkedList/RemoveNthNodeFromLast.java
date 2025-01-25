package LinkedList;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
public class RemoveNthNodeFromLast {
    public static ListNode deleteNodeFromEnd(ListNode head, int N) {
        // edge case
        if(head == null) return null;

        int count = 0;
        ListNode temp = head;

        // count the number of nodes in the linked list
        while(temp != null) {
            count++;
            temp = temp.next;
        }

        // If N equals the total number of nodes, delete the head
        if(count == N) {
            ListNode newHead = head.next;
            head = null;
            return newHead;
        }

        // Calculate the position of the node to delete (res)
        int result = count - N;
        temp = head;

        // Traverse to the node just before the one to delete
        while(temp != null) {
            result--;
            if(result == 0) {
                break;
            }
            temp = temp.next;
        }

        // Delete the Nth node from the end
        ListNode delNode = temp.next;
        temp.next = temp.next.next;
        delNode = null;
        return head;
    }

    public static void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int N = 3;
        ListNode head = new ListNode(arr[0]);
        head.next = new ListNode(arr[1]);
        head.next.next = new ListNode(arr[2]);
        head.next.next.next = new ListNode(arr[3]);
        head.next.next.next.next = new ListNode(arr[4]);

        // Delete the Nth node from 
        // the end and print the modified linked list
        head = deleteNodeFromEnd(head, N);
        printLL(head);
        System.out.println();
    }
}
