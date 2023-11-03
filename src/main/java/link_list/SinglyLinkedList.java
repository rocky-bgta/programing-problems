package link_list;
//https://www.youtube.com/watch?v=Fg4VIjTdHx4&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=37
public class SinglyLinkedList {

    private Node head;



    private static class Node {
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void insertFirst (int value){
        Node Node = new Node(value);
        Node.next = head;
        head = Node;
    }

    public void insertLast(int value){
        Node Node = new Node(value);
        if(head==null){
            head = Node;
            return;
        }
        Node current = head;
        while (null != current.next){
            current = current.next;
        }
        current.next = Node;
    }


    public boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reverseList(slow);
        fast = head;

        while (slow != null){
            if(slow.data != fast.data){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    //https://www.youtube.com/watch?v=jY-EUKXYT20&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=56
    public Node reverseList(Node head) {

        if(head!=null && head.next == null){
            return head;
        }

        Node current = head;
        Node previous = null;
        Node next ;

        while (current!=null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public boolean containsLoop(){
        Node fastPtr = head;
        Node slowPtr = head;

        while (fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(slowPtr == fastPtr){
                return true;
            }
        }

        return false;
    }

    public Node removeNthFromEnd(Node head, int n) {
        if(head == null)
            return null;

        //get length of list
        Node p = head;
        int len = 0;
        while(p != null){
            len++;
            p = p.next;
        }

        //if remove first node
        int fromStart = len-n+1;
        if(fromStart==1)
            return head.next;

        //remove non-first node
        p = head;
        int i=0;
        while(p!=null){
            i++;
            if(i==fromStart-1){
                p.next = p.next.next;
            }
            p=p.next;
        }
        return head;
    }
   // https://www.youtube.com/watch?v=IMWiPqoneT4&list=PL6Zs6LgrJj3tFNF3RvHDAvZcgOrvGWNRi&index=48
    public static Node marge(Node list1, Node list2){
        Node dummy = new Node(0);
        Node tail = dummy;

        while(list1 !=null  && list2 !=null){
            if(list1.data<list2.data){
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


    //https://www.youtube.com/watch?v=D0sFHueV30U&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=47
    public void insert(int position, int value){
        Node node = new Node(value);

        if(position==1){
            node.next = head;
            head = node;
        }else {
            Node previous = head;
            int count =1;
            while (count < position-1){
                previous = previous.next;
                count++;
            }

            Node current = previous.next;
            previous.next = node;
            node.next = current;

        }
    }

    //https://www.youtube.com/watch?v=2RwWsHePdr8
    public void delete(int position){
        if(position==1){
            head = head.next;
        }else {
            Node previous = head;
            int count = 1;
            while (count < position -1){
                previous = previous.next;
                count++;
            }
            Node current = previous.next;
            previous.next = current.next;
        }
    }

    public void display(Node head){
        Node current = head;
        while (current != null){
            System.out.print(current.data + "--->");
            current = current.next;
        }
        System.out.println("null");
    }

    public int length(){
        if(head==null) {
            return 0;
        }
        int count = 0;
        Node current = head;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();

        //linkListDemo.head = new ListNode(10);
//        ListNode second = new ListNode(1);
//        ListNode third = new ListNode(8);
//        ListNode fourth = new ListNode(11);
//
//        linkListDemo.head.next = second;
//        second.next = third;
//        third.next = fourth;

//        linkListDemo.insertLast(11);
//        linkListDemo.insertLast(8);
//        linkListDemo.insertLast(1);

//        list1.insertLast(1);
//        list1.insertLast(4);
//        list1.insertLast(8);

        SinglyLinkedList list2 = new SinglyLinkedList();


//        list2.insertLast(3);
//        list2.insertLast(5);
//        list2.insertLast(8);
//        list2.insertLast(9);
//        list2.insertLast(14);
//        list2.insertLast(18);
//        list2.display();
//        list2.delete(4);
//        list2.display();

        SinglyLinkedList list3 = new SinglyLinkedList();
        list3.insertLast(1);
        //list3.insertLast(2);
//        list3.insertLast(3);
//        list3.insertLast(4);
//        list3.insertLast(5);
        //list3.removeNthFromEnd(list3.head,1);
        //list3.display();

//
//        LinkListDemo list4 = new LinkListDemo();
//        list4.insertLast(1);
//        list4.insertLast(2);
//        list4.insertLast(3);
//
//        list4.display();
//        list4.reverseList(list4.head);
//[3,2,0,-4]
//        LinkListProblems list5 = new LinkListProblems();
//        list5.insertLast(1);
//        list5.insertLast(2);
//        list5.insertLast(3);


//        LinkListDemo result = new LinkListDemo();
//        result.head = marge(list1.head,list2.head) ;
//
//        result.display();


        //linkListDemo.display();
        //System.out.println("Length is - " + linkListDemo.length());

        //============================= reverse link list ========================
        Node head = new Node(10);
        Node second = new Node(8);
        head.next = second;


        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.display(head);
        singlyLinkedList.reverseList(head);
    }

}
