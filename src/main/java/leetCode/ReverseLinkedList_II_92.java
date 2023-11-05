package leetCode;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class ReverseLinkedList_II_92 {

    static ListNode head;

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode four = new ListNode(4);


        first.next = second;
        second.next = third;
        third.next = four;

        head = first;
        System.out.println("Original link list");
        display();

        System.out.println("After reverse link list");
        reverseBetween(head,1,2);

    }

    public static void display(){
        ListNode current = head; // actually head and first node pointing to the same memory location
        while (current != null){
            System.out.print(current.val + "--->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null)
            return head;

        int count = 0;
        ListNode leftPrevious = null, rightPrevious = null;
        ListNode leftNode = null;
        ListNode rightNode = null;

        ListNode currentNode = head;

        while (count < left) {
            leftPrevious = currentNode;
            leftNode = currentNode.next;
            currentNode = currentNode.next;
            count++;
        }
        count = 0;

        while (count < right-left) {
            //rightPrevious = currentNode;
            rightNode = currentNode.next;
            currentNode = currentNode.next;
            count++;
        }

        ListNode nextNode;
        ListNode previousNode = null;
        currentNode = leftNode;

        while (left < right) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;

            currentNode = nextNode;
            left++;
        }

        leftPrevious.next = previousNode;
        currentNode.next = rightNode.next;


        return  previousNode;
    }
}