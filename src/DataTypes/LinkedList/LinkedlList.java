package DataTypes.LinkedList;

public class LinkedlList {

    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next =null;

        }

    }

    public Node head = null;

    public void addBeginning(int data){

        Node newNode = new Node(data);

        if(head != null) {
            newNode.next = this.head;
        }
        this.head = newNode;
    }

    public void addEnd(int data){

        Node newNode = new Node(data);

        if(this.head == null){
            this.head = newNode;
        }else{
            Node curr = head;
            while(curr.next!=null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    public void add(int data, int position){

        Node newNode = new Node(data);
        if(position == 1) {
            addBeginning(data);
            return;
        }

        Node curr = this.head;
        Node prev = this.head;

        while(curr.next!=null && --position>0){
            prev = curr;
            curr = curr.next;
        }

        newNode.next = curr;
        prev.next = newNode;

    }

    public int  size(){
        Node curr = this.head;
        int index = 1;

        if (head==null) return 0;

        while(curr.next != null){
            curr = curr.next;
            index++;
        }
        return index;
    }

    public String toString(){
        Node curr = this.head;

        StringBuilder sb = new StringBuilder();

        if (head==null) return "Empty linked list";

        sb.append("Head : " + this.head.data);
        sb.append(" Values: ");
        while(curr.next != null){
            curr = curr.next;
            sb.append(" "+ curr.data);
        }

        return sb.toString();

    }

    public void reverse(Node head){

        Node curr = this.head;
        Node prev = null;
        Node next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        this.head = prev;

    }



    public static void main (String[] args){

        LinkedlList linkedlList = new LinkedlList();

        linkedlList.addEnd(10);
        linkedlList.addEnd(20);
        linkedlList.addEnd(30);

        linkedlList.reverse(linkedlList.head);
        System.out.println(linkedlList);

//        System.out.println(linkedlList.size());
//        System.out.println(linkedlList);
//
//        linkedlList.addBeginning(100);
//        System.out.println(linkedlList);
//
        //linkedlList.add(50, 3);
        //System.out.println(linkedlList);
    }

}
