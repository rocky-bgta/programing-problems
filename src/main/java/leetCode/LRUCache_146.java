package leetCode;

import dsa.data_structures.linked_lists.doubly_linked_list_implementation.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {


    class Node{
        int key;
        int value;
        Node next;
        Node prev;
    }

     Node head = new Node();
     Node tail = new Node();
     Map<Integer, Node> nodeMap;
    int cashCapacity;

    public LRUCache_146(int capacity) {
        nodeMap = new HashMap<>();
        this.cashCapacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
       return  0;
    }

    public void put(int key, int value) {

    }

    public void addToFirst(Node node) {
        Node newNode = new Node();
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void removeNode(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;

        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
