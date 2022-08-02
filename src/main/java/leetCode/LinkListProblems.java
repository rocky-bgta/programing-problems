package leetCode;

public class LinkListProblems {

    private ListNode head;

    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void insertFirst (int value){
        ListNode ListNode = new ListNode(value);
        ListNode.next = head;
        head = ListNode;
    }


    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

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


    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head!=null){
            ListNode next_node = head.next;
            head.next = prev;
            prev = head;
            head = next_node;
        }
        return prev;
    }

    public boolean containsLoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(slowPtr == fastPtr){
                return true;
            }
        }

        return false;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;

        //get length of list
        ListNode p = head;
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

    public static ListNode marge(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

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

    public void insertLast(int value){
        ListNode ListNode = new ListNode(value);
        if(head==null){
            head = ListNode;
            return;
        }
        ListNode current = head;
        while (null != current.next){
            current = current.next;
        }
        current.next = ListNode;
    }

    public void delete(int position){
        if(position==1){
            head = head.next;
        }else {
            ListNode previous = head;
            int count = 1;
            while (count < position -1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }

    public void display(){
        ListNode current = head;
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
        ListNode current = head;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LinkListProblems list1 = new LinkListProblems();

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

        LinkListProblems list2 = new LinkListProblems();


//        list2.insertLast(3);
//        list2.insertLast(5);
//        list2.insertLast(8);
//        list2.insertLast(9);
//        list2.insertLast(14);
//        list2.insertLast(18);
//        list2.display();
//        list2.delete(4);
//        list2.display();

        LinkListProblems list3 = new LinkListProblems();
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
        LinkListProblems list5 = new LinkListProblems();
        list5.insertLast(1);
        list5.insertLast(2);
        list5.insertLast(3);


//        LinkListDemo result = new LinkListDemo();
//        result.head = marge(list1.head,list2.head) ;
//
//        result.display();


        //linkListDemo.display();
        //System.out.println("Length is - " + linkListDemo.length());
    }

}
