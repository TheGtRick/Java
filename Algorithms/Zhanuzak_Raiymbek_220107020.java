public class Zhanuzak_Raiymbek_220107020{
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.add(3);
        list.add(2);
        list.add(0);
        list.add(-4);
        LinkedList.Node temp = list.head;
        while(temp.next != null) temp = temp.next;
        temp.next = list.head.next;
        System.out.println(list.check());
    }
}
class LinkedList{
    Node head;
    Node tail;
    class Node{
        Node next;
        int data;
        Node(int data){
            this.data = data;
        }
    }
    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = head;
        }
        else if(head == tail){
            tail = newNode;
            head.next = tail;
        }
        else{
            tail.next = newNode;
            tail = tail.next;
        }
    }
    public boolean check(){
        Node first = head;
        Node second = head;
        int index = 0;
        while(first != null && first.next != null && second != null && second.next != null && second.next.next != null){
            first = first.next;
            second = second.next.next;
            if(first == second){
                System.out.println("They are meeting in the node with value " + String.valueOf(first.data));
                System.out.println("Tail connected to the node with value " + String.valueOf(tail.next.data));
                Node temp = head;
                while(temp != tail.next){
                    temp = temp.next;
                    index++;
                }
                System.out.println("At index " + String.valueOf(index));
                return true;
            }
        }
        return false;
    }
}
