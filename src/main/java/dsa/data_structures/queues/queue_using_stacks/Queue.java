package dsa.data_structures.queues.queue_using_stacks;

import java.util.Stack;

/**
 * => we will use the inbuilt stack that comes in java.<br/>
 * => You can also use the stack that we built in stacks section<br/>
 * => both of the above approach would work fine with very minute modifications.
 */
public class Queue {
    // this is the main stack which we will use as queue
    Stack<Integer> queueStack = new Stack<>();
    // rev stack
    Stack<Integer> revStack = new Stack<>();

    public void push(int x) {
        if (this.queueStack.isEmpty()) {
            this.queueStack.push(x);
        } else {
            while (!this.queueStack.isEmpty()) {
                this.revStack.push(this.queueStack.pop());
            }
            this.revStack.push(x);
            while (!this.revStack.isEmpty()) {
                this.queueStack.push(this.revStack.pop());
            }
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public Integer pop() {
        if (!this.queueStack.isEmpty()) {
            return this.queueStack.pop();
        } else {
            return null;
        }

    }

    /**
     * Get the front element.
     */
    public Integer peek() {
        if (!this.queueStack.isEmpty()) {
            return this.queueStack.get(this.queueStack.size() - 1);
        } else {
            return null;
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return this.queueStack.isEmpty();
    }

    public static void main(String[] args) {
        Queue myQueue = new Queue();
        myQueue.push(10);
        myQueue.push(20);
        myQueue.push(30);
        // the last element in the queueStack will be our first item of queue.
        System.out.println("queue: "+myQueue.queueStack);
        System.out.println("peek: "+myQueue.peek());
        System.out.println("pop: "+myQueue.pop());
        System.out.println("queue: "+myQueue.queueStack);
        System.out.println("peek: "+myQueue.peek());
        System.out.println("is queue empty: "+myQueue.empty());
    }
}
