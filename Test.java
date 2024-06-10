public class Test{
    public static void main(String[] args){
        LinkedList l = new LinkedList();
        l.addNode(0);
        l.addNode(1);
        l.addNode(2);
        l.addNode(3);
        l.addNode(4);
        l.addNode(5);
        LinkedList.Node current = l.head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
        l.reverse();
        current = l.head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
class LinkedList{
    class Node{
        int data;
        Node prev;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    Node head, tail = null;
    public void addNode(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            head.prev = null;
            head.next = null;
            tail.next = null;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = null;
        }
    }
    public void reverse(){
        Node temp = null;
        Node current = head;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
         if (temp != null) {
            head = temp.prev;
        }
    }
}