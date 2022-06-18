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
        LinkListDemo linkListDemo = new LinkListDemo();

        linkListDemo.head = new LinkNode(10);
//        LinkNode second = new LinkNode(1);
//        LinkNode third = new LinkNode(8);
//        LinkNode fourth = new LinkNode(11);
//
//        linkListDemo.head.next = second;
//        second.next = third;
//        third.next = fourth;

        linkListDemo.insertLast(11);
        linkListDemo.insertLast(8);
        linkListDemo.insertLast(1);

        linkListDemo.display();
        System.out.println("Length is - " + linkListDemo.length());
    }

}
