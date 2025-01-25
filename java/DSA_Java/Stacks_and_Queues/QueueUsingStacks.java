package Stacks_and_Queues;
import java.util.*;

class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        // remove the uppermost element
        peek();
        return s2.pop();
    }

    public int peek() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
public class QueueUsingStacks {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.pop()); // output -> 1
        System.out.println(queue.peek()); // output -> 2
        System.out.println(queue.empty()); // output -> false
    }
}
