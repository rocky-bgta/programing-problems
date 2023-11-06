package leetCode.linklist;

/*
    https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/
    Explanation: Udemy
 */

public class MultilevelDoublyLinkedList_430 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        ListNode child;

        public ListNode(int val, ListNode next, ListNode prev, ListNode child) {
            this.val = val;
            this.next = next;
            this.prev = prev;
            this.child = child;
        }
    }

    public ListNode flatten(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode currentNode = head;
        while (currentNode != null) {
            if (currentNode.child == null) {
                currentNode = currentNode.next;
            } else {
                ListNode tail = currentNode.child;
                while (tail.next != null) {
                    tail = tail.next;
                }

                tail.next = currentNode.next;
                if (tail.next != null) {
                    tail.next.prev = tail;
                }

                currentNode.next = currentNode.child;
                currentNode.next.prev = currentNode;
                currentNode.child = null;
            }
        }

        return head;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Your test case input
        // Example usage
        MultilevelDoublyLinkedList_430 solution = new MultilevelDoublyLinkedList_430();
        ListNode node1 = new ListNode(1, null, null, null);
        ListNode node2 = new ListNode(2, null, null, null);
        ListNode node3 = new ListNode(3, null, null, null);

        // Connect nodes (manually creating a multi-level linked list)
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;

        // Flatten the multi-level linked list
        ListNode flattenedList = solution.flatten(node1);

        // Print the flattened list
        solution.printList(flattenedList);
    }
}
