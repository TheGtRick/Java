public class Exercise8{
    public static void main(String[] args){
        CircularQueue queue = new CircularQueue(10);
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.toString());
        for(int i = 0; i < 20; i++){
            System.out.println(queue.peek());
            queue.moveCur();
        }
        
    }
}
class CircularQueue{
        Node first;
        Node last;
        int size;
        int crsize = 0;
        Node current;
        CircularQueue(int size){
            this.size = size;
        }
        class Node{
            Node next;
            int value;
            Node(int value){
                this.value = value;
            }
        }
        public void enqueue(int value){
            if(crsize == size){
                System.out.println("Queque is full");
            }
            else{
                Node b  = new Node(value);
                if(first == null){
                    first = b;
                    last = first;
                    first.next = last;
                    last.next = first;
                    current = first;
                }
                else if(last == null){
                    last = b;
                    first.next = last;
                    last.next = first;
                }
                else{
                    last.next = b;
                    last = last.next;
                    last.next = first;
                }
                crsize++;
            }
            
        }
        public void dequeue(){
            if(first == null) System.out.println("Queque is empty");
            else{
                first = first.next;
                last.next = last.next.next;
                size--;
            }
        }
        public int peek(){
            return current.value;
    }
    public String toString(){
        String a = "(";
        Node temp = first;
        while(temp != last){
            a += String.valueOf(temp.value) + ", ";
            temp = temp.next;
        }
        a += String.valueOf(last.value) + ")";
        return a;
    }
    public void moveCur(){
        if(current != null) current = current.next;
        else System.out.println("Queue is empty");
    }
}
class Queue{
    Node first;
    Node last;
    int crsize = 0;
    class Node{
        Node next;
        int value;
        Node(int value){
            this.value = value;
        }
    }
    public void enqueue(int value){
        Node b = new Node(value);
        if(first == null){
            first = b;
            last = b;
        }
        else{
            last.next = b;
            last = last.next;
        }
    }
    public void dequeue(){
        if(first == null) System.out.println("Queue is empty");
        else first = first.next;
    }
    public int peek(){
        return first.value;
    }
}