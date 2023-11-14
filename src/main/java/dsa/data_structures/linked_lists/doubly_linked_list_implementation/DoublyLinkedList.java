package dsa.data_structures.linked_lists.doubly_linked_list_implementation;

import java.util.Arrays;

/*
    https://www.youtube.com/watch?v=MRIBUvW_KT4&list=PL6Zs6LgrJj3tFNF3RvHDAvZcgOrvGWNRi&index=37
 */

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value) {
        head = new Node(value);
        tail = head;
        length = 1;

//        head.next = tail;
//        tail.prev = head;
    }

    public void addToLast(int value) {
        Node newNode = new Node(value);
        newNode.previous = tail;
        tail.next = newNode;
        tail = newNode;
        length++;
    }

    public void addToFirst(int value) {
        Node newNode = new Node(value);
        head.previous = newNode;
        newNode.next = head;
        head = newNode;
        length++;
    }

    public int getLength() {
        return length;
    }

    public int[] printList() {
        int[] myList = new int[length];
        Node current = this.head;
        int i = 0;
        while (current != null) {
            myList[i] = current.value;
            current = current.next;
            i++;
        }
        return myList;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > length) {
            System.err.println("Index Out Of Bounds For Length " + length);
        } else if (index == 0) {
            addToFirst(value);
        } else if (index == length) {
            addToLast(value);
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node newNode = new Node(value);
            newNode.next = current.next;
            current.next = newNode;
            newNode.previous = current;
            newNode.next.previous = newNode;
            length++;
        }
    }

    public void addNodeToFirst(Node node){
        Node tempNode = head.next;
        node.next  = tempNode;
        tempNode.previous = node;
        head.next = node;
        head = node;
    }

    public void removeNode(Node node){
        Node nextNode = node.next;
        Node prevNode = node.previous;

        nextNode.previous = prevNode;
        prevNode.next = nextNode;
    }

    public void remove(int index) {
        if (index < 0 || index > length) {
            System.err.println("Index Out Of Bounds For Length " + length);
        } else if (index == 0) {
            head = this.head.next;
            this.head.previous = null;
            length--;
        } else {
            Node current = head;
            int i;
            for (i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            length--;
            if (i == length - 1) {
                tail = current;
            } else {
                current.next.previous = current;
            }
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList myDoublyLinkedList = new DoublyLinkedList(1);
        myDoublyLinkedList.addToLast(2);
        myDoublyLinkedList.addToLast(3);
        Node node = new Node (4);
        myDoublyLinkedList.addNodeToFirst(node);
        System.out.println(Arrays.toString(myDoublyLinkedList.printList()));
//        myDoublyLinkedList.addToLast(3);
//        myDoublyLinkedList.addToLast(4);
//        myDoublyLinkedList.addToFirst(2);
//        myDoublyLinkedList.addToFirst(1);
//        System.out.println(Arrays.toString(myDoublyLinkedList.printList()));
//        myDoublyLinkedList.remove(0);
//        System.out.println(Arrays.toString(myDoublyLinkedList.printList()));
//        myDoublyLinkedList.insert(2, 200);
//        System.out.println(Arrays.toString(myDoublyLinkedList.printList()));
//        System.out.println("length: " + myDoublyLinkedList.getLength());
//
//        System.out.println("head value: " + myDoublyLinkedList.head.value);
//        System.out.println("head.previous: " + myDoublyLinkedList.head.previous);
//
//        System.out.println("tail value: " + myDoublyLinkedList.tail.value);
//        System.out.println("tail.next: " + myDoublyLinkedList.tail.next);
    }
}
