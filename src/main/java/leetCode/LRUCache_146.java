package leetCode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {

    // Inner class representing a node in the doubly linked list
    class Node {
        int key;        // Key of the cache entry
        int value;      // Value associated with the key
        Node next;      // Reference to the next node in the list
        Node prev;      // Reference to the previous node in the list
    }

    Node head = new Node(); // Dummy head node to simplify boundary conditions
    Node tail = new Node(); // Dummy tail node to simplify boundary conditions
    Map<Integer, Node> nodeMap; // HashMap to store key -> Node mappings for O(1) access
    int cashCapacity;   // Maximum capacity of the cache

    // Constructor to initialize the LRU Cache with a given capacity
    public LRUCache_146(int capacity) {
        nodeMap = new HashMap<>(); // Initialize the HashMap
        this.cashCapacity = capacity; // Set the cache capacity
        head.next = tail; // Connect head to tail (empty list)
        tail.prev = head; // Connect tail to head (empty list)
    }

    // Method to retrieve the value associated with a key
    public int get(int key) {
        int result = -1; // Default value if key is not found
        Node node = nodeMap.get(key); // Retrieve the node from the HashMap
        if (node != null) { // If the key exists in the cache
            result = node.value; // Get the value from the node
            removeNode(node); // Remove the node from its current position
            addToFirst(node); // Move the node to the front (mark as recently used)
        }
        return result; // Return the value (or -1 if key not found)
    }

    // Method to insert or update a key-value pair in the cache
    public void put(int key, int value) {
        Node node = nodeMap.get(key); // Check if the key already exists
        if (node != null) { // If the key exists
            removeNode(node); // Remove the node from its current position
            node.value = value; // Update the node's value
            addToFirst(node); // Move the node to the front (mark as recently used)
        } else { // If the key does not exist
            if (nodeMap.size() == cashCapacity) { // If the cache is full
                nodeMap.remove(tail.prev.key); // Remove the least recently used node (before tail) from the HashMap
                removeNode(tail.prev); // Remove the least recently used node from the linked list
            }

            Node newNode = new Node(); // Create a new node
            newNode.key = key; // Set the key
            newNode.value = value; // Set the value
            nodeMap.put(key, newNode); // Add the new node to the HashMap
            addToFirst(newNode); // Add the new node to the front of the linked list
        }
    }

    // Helper method to add a node to the front of the linked list (just after head)
    public void addToFirst(Node node) {
        Node headNext = head.next; // Get the current first node in the list
        node.next = headNext; // Set the new node's next pointer to the current first node
        headNext.prev = node; // Set the current first node's previous pointer to the new node

        head.next = node; // Set head's next pointer to the new node
        node.prev = head; // Set the new node's previous pointer to head
    }

    // Helper method to remove a node from the linked list
    public void removeNode(Node node) {
        Node nextNode = node.next; // Get the next node
        Node prevNode = node.prev; // Get the previous node

        nextNode.prev = prevNode; // Update the next node's previous pointer to skip the current node
        prevNode.next = nextNode; // Update the previous node's next pointer to skip the current node
    }

    // Main function for testing the LRUCache_146 implementation
    public static void main(String[] args) {
        // Create a cache with capacity 2
        LRUCache_146 cache = new LRUCache_146(2);

        // Test case 1: Insert key 1 with value 10
        cache.put(1, 10);
        System.out.println("Inserted (1, 10). Cache state: ");
        printCache(cache);

        // Test case 2: Insert key 2 with value 20
        cache.put(2, 20);
        System.out.println("Inserted (2, 20). Cache state: ");
        printCache(cache);

        // Test case 3: Retrieve value for key 1
        System.out.println("Get key 1: " + cache.get(1)); // Expected: 10
        System.out.println("Cache state after get(1): ");
        printCache(cache);

        // Test case 4: Insert key 3 with value 30 (this will evict key 2)
        cache.put(3, 30);
        System.out.println("Inserted (3, 30). Cache state: ");
        printCache(cache);

        // Test case 5: Retrieve value for key 2 (should return -1 as it was evicted)
        System.out.println("Get key 2: " + cache.get(2)); // Expected: -1
        System.out.println("Cache state after get(2): ");
        printCache(cache);

        // Test case 6: Update value for key 1
        cache.put(1, 100);
        System.out.println("Updated (1, 100). Cache state: ");
        printCache(cache);

        // Test case 7: Retrieve value for key 3
        System.out.println("Get key 3: " + cache.get(3)); // Expected: 30
        System.out.println("Cache state after get(3): ");
        printCache(cache);
    }

    // Helper method to print the current state of the cache
    public static void printCache(LRUCache_146 cache) {
        Node current = cache.head.next; // Start from the first real node (after head)
        System.out.print("Cache: ");
        while (current != cache.tail) { // Traverse until we reach the tail dummy node
            System.out.print("(" + current.key + ", " + current.value + ") ");
            current = current.next;
        }
        System.out.println();
    }
}