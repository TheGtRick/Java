import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args){
        DoubleLinkedList list = new DoubleLinkedList();
        Scanner scanner = new Scanner(System.in);
        String[] sentence = scanner.nextLine().split(" ");
        for(int i = 0; i< sentence.length; i++){
            list.add(sentence[i]);
        }
        list.undo();
        list.redo();
        list.undo();
        list.undo();
    }
}
class DoubleLinkedList{
    Node head;
    Node tail;
    Node current;
    class Node{
        Node prev;
        Node next;
        String data;
        public Node(String data){
            this.data = data;
        }
    }
    public void add(String data){
        if(head == null){
            head = new Node(data);
            head.next = tail;
            tail = head;
            current = head;
        }
        else{
            Node newNode = new Node(data);
            tail.next = newNode;
            tail.next.prev = tail;
            tail = tail.next;
            current = tail;
        }
    }
    public void undo(){
        String a = "";
        Node temp = head;
        if(current != head){
            while(temp != current){
                a += temp.data + " ";
                temp = temp.next;
            }
            current = current.prev;
        }
        System.out.println(a);
    }
    public void redo(){
        String a = "";
        Node temp = head;
        if(current.next != null){
            while(temp != current.next){
                a += temp.data + " ";
                temp = temp.next;
            }
            a += temp.data + " ";
            current = current.next;
        }
        else while(temp != null){
                a += temp.data;
                temp = temp.next;
            }
        System.out.println(a);
    }
    public void show(){
        System.out.println(current.data);
    }
}