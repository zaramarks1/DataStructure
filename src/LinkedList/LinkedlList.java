package LinkedList;

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
        int index = 0;

        if (head==null) return 0;

        while(curr.next != null){
            curr = curr.next;
            index++;
        }
        return index;
    }

}
