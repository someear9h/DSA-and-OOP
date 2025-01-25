package Stacks_and_Queues;
import java.util.*;

class MyStack {
    private Queue<Integer> q;

    // constructor
    MyStack() {
        q = new LinkedList<>();
    }

    // push
    public void push(int x) {
        q.add(x);
        for(int i = 0; i < q.size() - 1; i++) {
            q.add(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

public class StackUsingQueues {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.top());  // Output: 3
        System.out.println(stack.pop());  // Output: 3
        System.out.println(stack.top());  // Output: 2
        System.out.println(stack.empty()); // Output: false

        stack.pop(); // Removes 2
        stack.pop(); // Removes 1
        System.out.println(stack.empty()); // Output: true
    }
}


