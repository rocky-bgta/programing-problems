package dsa.data_structures.stacks.stack_using_linkedlists;

public class Stack {
    private Node top;
    private Node bottom;
    private int length;

    public Stack() {
        top = null;
        bottom = null;
        length = 0;
    }

    public String peek() {
        if (length > 0) {
            return top.value;
        } else {
            return null;
        }
    }

    public void push(String value) {
        Node newNode = new Node(value);
        if (length == 0) {
            top = newNode;
            bottom = newNode;
        } else {
            newNode.next = top; // top actually represent here previous node 1. link newNode to previous node
            top = newNode;                                                 //2. then represent newNode as top
        }
        this.length++;
    }

    public Node pop() {
        Node tempTop=null;
        if (length > 0) {
            tempTop = top;
            top = top.next;

            if (length == 1) {
                bottom = null;
            }
            length--;
        }
        return tempTop;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public String getLastElement() {
        if (length > 0) {
            return bottom.value;
        }
        return null;
    }

    public static void main(String[] args) {
        Stack myStack = new Stack();
        myStack.push("Google");
        myStack.push("Udemy");
        myStack.push("Discord");
        System.out.println(myStack.peek());
        Node value = myStack.pop();
        System.out.println(value);
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.getLastElement());
    }
}
