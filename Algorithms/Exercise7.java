public class Exercise7 {
    public static void main(String[] args){
        LinkedList l = new LinkedList();
        l.add(0);
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(2);
        l.add(5);
        l.add(6);
        l.show();
        l.removeAll(2);
        l.show();
    }
}
class LinkedList{
    Node head = null;
    Node tail = null;
    class Node{
        public int value;
        public Node next = null;
        Node(int value){
            this.value = value;
        }
    }
    public void add(int value){
        if(head == null){
            head = new Node(value);
            tail = head;
        }
        else{
            tail.next = new Node(value);
            tail = tail.next;
        }
    }
    public void remove(int value){
        Node temp = head;
        while(temp.next.value != value){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
    public void removeAll(int value){
        Node temp = head;
        while(temp.next != null){
            if(temp.next.value == value){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    }
    public void show(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}