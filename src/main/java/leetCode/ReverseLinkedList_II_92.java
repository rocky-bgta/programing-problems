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

    /*
        Explanation on Udemy course
     */

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int currentPosition =1;
        ListNode currentNode = head;
        ListNode start = head;

        while(currentPosition < left){
            start = currentNode;
            currentNode = currentNode.next;
            currentPosition++;
        }

        ListNode newList = null;
        ListNode tail=currentNode;

        while(currentPosition>=left && currentPosition<=right){
            ListNode next = currentNode.next;
            currentNode.next = newList;
            newList = currentNode;
            currentNode = next;
            currentPosition++;
        }

        start.next = newList;
        tail.next = currentNode;

        if(left>1){
            return head;
        }else {
            return newList;
        }
    }
}