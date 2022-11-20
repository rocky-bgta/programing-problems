package linkList;

//https://www.youtube.com/watch?v=sUcVDPDHFJg&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=73

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    private class ListNode{
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data){
            this.data = data;
        }


    }

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public int length(){
        return length;
    }

    public void displayForward(){
        if(head==null){
            return;
        }

        ListNode temp = head;

        while (temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();

    }

    public void displayBackward(){
        if(tail==null){
            return;
        }

        ListNode temp = tail;
        while (temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.previous;
        }
        System.out.print("null");
        System.out.println();
    }

        //https://www.youtube.com/watch?v=jircscEJnWI&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=75
    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            tail = newNode;
        }else {
            head.previous = newNode;
            newNode.next = head;
        }

        head = newNode;
        length++;
    }

    public void insertByGivenIndex(int index, int value) {
        if (index < 0 || index > length) {
            System.err.println("Index Out Of Bounds For Length " + length);
        } else if (index == 0) {
            insertFirst(value);
        } else if (index == length) {
            insertLast(value);
        } else {
            ListNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            //next node
            ListNode nextNode = current.next;

            ListNode newNode = new ListNode(value);

            current.next = newNode;
            newNode.previous=current;

            newNode.next = nextNode;
            nextNode.previous = newNode;

            length++;
        }
    }

    public void removeByGivenIndex(int index) {
        if (index < 0 || index > length) {
            System.err.println("Index Out Of Bounds For Length " + length);
        } else if (index == 0) { // check corner case
            head = this.head.next;
            this.head.previous = null;
            length--;
        }if(index==length){ // check corner case
            ListNode current = head;
            for (int i = 0; i < length-2; i++) {
                current = current.next;
            }
            current.next=null;
            current.previous=null;
        }
        else {
            ListNode current = head;
            //previous node that is before the deleted node
            for (int i = 0; i < index - 2; i++) {
                current = current.next;
            }
            //next node after the deleted node
            ListNode nextNode = current.next.next;


            current.next = nextNode;
            nextNode.previous=current;

            length++;
        }
    }

    //https://www.youtube.com/watch?v=E-v7WYdzuuw&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=76
    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            head = newNode;
        }else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
//        doublyLinkedList.insertFast();(1);
//        doublyLinkedList.insertFirst();(10);
//        doublyLinkedList.insertFirst();(15);
//        doublyLinkedList.insertFirst();(25);
//
//        doublyLinkedList.insertLast(1);
//        doublyLinkedList.insertLast(10);
//        doublyLinkedList.insertLast(15);
//        doublyLinkedList.insertLast(25);
//        doublyLinkedList.insertLast(40);
//
//        doublyLinkedList.insertByGivenIndex(3,30);


        doublyLinkedList.insertLast(1);
        doublyLinkedList.insertLast(20);
        doublyLinkedList.insertLast(40);
        doublyLinkedList.insertLast(50);
        doublyLinkedList.insertLast(60);

        doublyLinkedList.displayForward();

        doublyLinkedList.removeByGivenIndex(5);

        doublyLinkedList.displayForward();
       // doublyLinkedList.displayBackward();
    }
}
