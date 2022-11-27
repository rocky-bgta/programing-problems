package dsa.data_structures.linked_lists.linked_list_implementation;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        head = new Node(value);
        tail = head;
        length = 1;
    }
    //insert value to last
    public void addToLast(int value) {
        Node newNode = new Node(value);
        tail.next = newNode;
        tail = newNode;
        length++;
    }

    //insert value to first
    public void addToFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        length++;
    }

    public int getLength() {
        return length;
    }

//    public int[] printList() {
//        int[] myList = new int[length];
//        Node current = this.head;
//        int i = 0;
//        while (current != null) {
//            myList[i] = current.value;
//            current = current.next;
//            i++;
//        }
//        return myList;
//    }

    public void printList(){
        Node current = head;
        while (current != null){
            System.out.print(current.value + "--->");
            current = current.next;
        }
        System.out.println("null");
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
            Node temp= current.next; //hold link
            current.next = newNode;
            newNode.next=temp;
//            newNode.next = current.next;
//            current.next = newNode;
             length++;
        }
    }

    public void remove(int index) {
        if (index < 0 || index > length) {
            System.err.println("Index Out Of Bounds For Length " + length);
        } else if (index == 0) {
            head = this.head.next;
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
            }
        }
    }

    public LinkedList reverse(LinkedList linkedList) {
        LinkedList newList = new LinkedList(linkedList.head.value);
        Node current = linkedList.head;
        while (current.next != null) {
            current = current.next;
            Node newNode = new Node(current.value);
            newNode.next = newList.head;
            newList.head = newNode;
            newList.length++;
        }
        return newList;
    }

    //https://www.youtube.com/watch?v=QnDqtsU2VXY
    public void findMiddleNode(){
        Node slowPointer = head;
        Node firstPointer = head;
        while (firstPointer!=null && firstPointer.next!=null){
            slowPointer = slowPointer.next;
            firstPointer = firstPointer.next.next;
        }
        System.out.println(slowPointer.value);
    }

    //https://www.youtube.com/watch?v=QnDqtsU2VXY
    public void findCycleInLinkList(){
        Node slowPointer = head;
        Node firstPointer = head;
        while (slowPointer!=null && firstPointer!=null && firstPointer.next!=null){
            slowPointer = slowPointer.next;
            firstPointer = firstPointer.next.next;

            if(slowPointer == firstPointer){
                System.out.println("We have a loop at node : "+ slowPointer.value);
                break;
            }

        }
    }

   // https://www.youtube.com/watch?v=FUzDWFAQNE4
    public Node removeKthElementFromEnd(LinkedList list, int n){
         int length =1;
         Node head = this.head;
         Node temp = head;

         while (temp.next!=null){
             length++;
             temp = temp.next;
         }

         if(n==length){
             this.head = this.head.next;
             return this.head;
         }

         int index = length-n;
         temp = this.head;
         for(int i=0; i<index-1; i++){
             temp = temp.next;
         }
         temp.next = temp.next.next;

         return this.head;

    }


    //https://leetcode.com/problems/merge-two-sorted-lists/
    // https://www.youtube.com/watch?v=IMWiPqoneT4&list=PL6Zs6LgrJj3tFNF3RvHDAvZcgOrvGWNRi&index=48
    public Node marge(Node list1, Node list2){
        Node dummy = new Node(0);
        Node tail = dummy;

        while(list1 !=null  && list2 !=null){
            if(list1.value<list2.value){
                tail.next = list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if(list1 == null){
            tail.next = list2;
        }else{
            tail.next = list1;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
//        LinkedList myLinkedList = new LinkedList(10);
        //append
       // myLinkedList.append(20); //Add to last
        //myLinkedList.append(30);
        //prepend
//        myLinkedList.append(20);
//        myLinkedList.append(30);
//        myLinkedList.append(40); //add to first
//        myLinkedList.append(50);

        //========= create loop in link list ================
       //myLinkedList.head.next.next = myLinkedList.head.next;
                   // 10   20   30                 <----20

        //myLinkedList.findCycleInLinkList();
        //===================================================
//        myLinkedList.append(60);
//        myLinkedList.append(70);
//        myLinkedList.append(80);
//        myLinkedList.append(90);
//        myLinkedList.append(100);

        //myLinkedList.prepend(100);
//        System.out.println("length: " + myLinkedList.getLength());
//        System.out.println("list: " + Arrays.toString(myLinkedList.printList()));
          //insert
//        myLinkedList.insert(2, 25);
//        System.out.println("length: " + myLinkedList.getLength());
//        System.out.println("list: " + Arrays.toString(myLinkedList.printList()));
        //remove
//        myLinkedList.remove(4);
//        System.out.println("length: " + myLinkedList.getLength());
        //System.out.println("list: " + Arrays.toString(myLinkedList.printList()));
//          myLinkedList.printList();
        //reverse
//        LinkedList linkedList2 = myLinkedList.reverse(myLinkedList);
//        System.out.println("reverse linkedList" + Arrays.toString(linkedList2.printList()));
//        myLinkedList.findMiddleNode();

        // remove node for kth position from end
//        int n =5;
//        myLinkedList.removeKthElementFromEnd(myLinkedList,n);
//        myLinkedList.printList();
        //System.out.println("list: " + Arrays.toString(myLinkedList.printList()));

        //======== marge two sorted link list ===================
        LinkedList list1 = new LinkedList(1);
        list1.addToLast(2);
        list1.addToLast(4);

        LinkedList list2 = new LinkedList(1);
        list2.addToLast(3);
        list2.addToLast(4);

        list1.marge(list1.head, list2.head);


    }
}
