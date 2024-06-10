import java.lang.Math;
public class HomeWork1 {
    public static void main(String[] args){
        CircularLinkedList list = new CircularLinkedList();
        list.add("High Enough");
        list.add("Keeps On Giving");
        list.add("Invincible");
        list.add("Adorable");
        list.show();
        list.forward();
        list.forward();;
        list.backward();
        list.remove("Invincible");
        
    }
}

class CircularLinkedList{
    Node head;
    Node tail;
    Node current;
    int size = 0;
    class Node{
        Node next;
        Node prev;
        String data;
        Node(String data){
            this.data = data;
        }
    }
    public void add(String data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            tail = head;
            head.next = tail;
            tail.next = head;
            head.prev = tail;
            tail.prev = head;
            size++;
            current = head;
        }
        else{
            tail.next = newNode;
            tail.next.next = head;
            head.prev = tail.next;
            tail.next.prev = tail;
            tail = tail.next;
            size++;
        }
    }
    public Node peek(int l){
        Node temp = head;
        int i = 0;
        while(i != l){
            temp = temp.next;
            i++;
        }
        return temp;
    }
    public void remove(String data){
        if(head == null){
            System.out.println("List is empty");
        }
        else{
            if(head.data.equals(data)){
            head = head.next;
            head.prev = tail;
            tail.next = head;
            }
            else if(tail.data.equals(data)){
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
            }
            else{
                Node temp = tail;
                while(!temp.next.data.equals(data)){
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                temp.next.next.prev = temp;
            }
            size--;
        }
    }
    public String shuffle(){
        long i = Math.round(Math.random() * size);
        Node temp = head;
        long j = 0;
        while(j != i){
            temp = temp.next;
            j++;
        }
        return temp.data;
    }
    public void forward(){
        current = current.next;
    }
    public void backward(){
        current = current.prev;
    }
    public void show(){
        System.out.println(current.data);
    }
}