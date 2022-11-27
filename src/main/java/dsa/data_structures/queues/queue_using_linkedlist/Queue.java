package dsa.data_structures.queues.queue_using_linkedlist;

public class Queue {
    Node first;
    Node last;
    int length;

    Queue(){
        this.first = null;
        this.last = null;
        this.length =0;
    }

    public String peek() {
        if (this.length > 0) {
            return this.first.value;
        } else {
            return null;
        }
    }

    public void enqueue(String value) {
        Node newNode = new Node(value);
        if (this.length == 0) {
            this.first = newNode;
        } else {
            this.last.next = newNode; // last.next here represent previous node
        }
        this.last = newNode;
        this.length++;
    }

    public Node dequeue() {
        Node tempNode=null;
        if (this.length > 0) {
            tempNode = this.first;
            this.first = this.first.next;

            if (this.length == 1) {
                this.last = null;
            }
            this.length--;
        }
        return tempNode;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public static void main(String[] args) {
        Queue myQueue = new Queue();
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.peek());
        myQueue.enqueue("Apple");
        myQueue.enqueue("Ball");
        myQueue.enqueue("Cat");
        Node node = myQueue.dequeue();
        System.out.println(node.value);
        System.out.println(myQueue.peek());
    }
}
