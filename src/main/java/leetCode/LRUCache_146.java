package leetCode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {


    class Node {
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
        int result = -1;
        Node node = nodeMap.get(key);
        if (node != null) {
            result = node.value;
            removeNode(node);
            addToFirst(node);
        }
        return result;
    }

    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        if (node != null) {
            removeNode(node);
            node.value = value;
            addToFirst(node);
        } else {
            if (nodeMap.size() == cashCapacity) {
                nodeMap.remove(tail.prev.key);
                removeNode(tail.prev);
            }

            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            nodeMap.put(key, newNode);
            addToFirst(newNode);
        }
    }

    public void addToFirst(Node node) {
        Node headNext = head.next;
        node.next = headNext;
        headNext.prev = node;

        head.next = node;
        node.prev = head;
    }

    public void removeNode(Node node) {
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
