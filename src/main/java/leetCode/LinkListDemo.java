package leetCode;

public class LinkListDemo {

    private LinkNode head;

    private static class LinkNode{
        private int data;
        private LinkNode next;

        public LinkNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void insertFirst (int value){
        LinkNode linkNode = new LinkNode(value);
        linkNode.next = head;
        head = linkNode;
    }

    public static LinkNode marge(LinkNode list1, LinkNode list2){
        LinkNode dummy = new LinkNode(0);
        LinkNode tail = dummy;

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
        LinkNode linkNode = new LinkNode(value);
        if(head==null){
            head = linkNode;
            return;
        }
        LinkNode current = head;
        while (null != current.next){
            current = current.next;
        }
        current.next = linkNode;
    }

    public void display(){
        LinkNode current = head;
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
        LinkNode current = head;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LinkListDemo list1 = new LinkListDemo();

        //linkListDemo.head = new LinkNode(10);
//        LinkNode second = new LinkNode(1);
//        LinkNode third = new LinkNode(8);
//        LinkNode fourth = new LinkNode(11);
//
//        linkListDemo.head.next = second;
//        second.next = third;
//        third.next = fourth;

//        linkListDemo.insertLast(11);
//        linkListDemo.insertLast(8);
//        linkListDemo.insertLast(1);

        list1.insertLast(1);
        list1.insertLast(4);
        list1.insertLast(8);

        LinkListDemo list2 = new LinkListDemo();

        list2.insertLast(3);
        list2.insertLast(5);
        list2.insertLast(8);
        list2.insertLast(9);
        list2.insertLast(14);
        list2.insertLast(18);

        LinkListDemo result = new LinkListDemo();
        result.head = marge(list1.head,list2.head) ;

        result.display();


        //linkListDemo.display();
        //System.out.println("Length is - " + linkListDemo.length());
    }

}
