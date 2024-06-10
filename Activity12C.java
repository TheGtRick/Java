import java.util.*;
class StackNode<E> {
    E data;
    StackNode<E> next;
    public StackNode(E data) {
        this.data = data;
    }
}
class LinkedStack<E> {
    private StackNode<E> top;
    private int size;
    public LinkedStack(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            push(objects[i]);
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void push(E e) {
        StackNode<E> current = new StackNode<>(e);
        current.next = top;
        top = current;
        size++;
    }
    public E pop() throws EmptyStackException {
        if (top == null) throw new EmptyStackException();
        E current = top.data;
        top = top.next;
        size--;
        return current;
    }
    public E peek() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return top.data;
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[ ");
            StackNode<E> current = top;
            while (current != null) {
                s.append(current.data).append(" ");
                current = current.next;
            }
            s.append("]");
        return s.toString();
    }
    public Iterator<E> iterator() {
        return new StackIterator();
    }
    class StackIterator implements Iterator<E> {
        boolean canRemove = false;
        int previousLoc = -1;
        StackNode<E> current = top;
        @Override
        public boolean hasNext() {
            return current!=null ;
        }
        @Override
        public E next() {
            if(hasNext()){
                E data = current.data;
                current = current.next;
                previousLoc++;
                canRemove = true;
                return data;
            }else throw new NoSuchElementException();
        }
    }
    class StackListIterator implements ListIterator<E> {
        boolean canRemove = false;
        int previousLoc = -1;
        int nextIndex = 0;
        StackNode<E> current = top;
        StackNode<E> last;
        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public E next() {
            if (hasNext()) {
                if(last == null){
                    StackNode<E> newStack = new StackNode<>(current.data);
                    last = newStack;
                    previousLoc++;
                }else{
                    StackNode<E> newStack = new StackNode<>(current.data);
                    newStack.next = last;
                    last = newStack;
                    previousLoc++;
                }
                nextIndex++;
                E e = current.data;
                current = current.next;
                return e;
            }else{
                throw new NoSuchElementException();
            }
        }
        @Override
        public boolean hasPrevious() {
            return last != null;
        }
        @Override
        public E previous() {
            if(hasPrevious()) {
                if (current == null) {
                    StackNode<E> newStack = new StackNode<E>(last.data);
                    current = newStack;
                    nextIndex--;
                } else {
                    StackNode<E> newStack = new StackNode<E>(last.data);
                    newStack.next = current;
                    current = newStack;
                    nextIndex--;
                }
                previousLoc--;
                E e = last.data;
                last = last.next;
                return e;
            }
            else return null;
        }
        @Override
        public int nextIndex() {
            return nextIndex;
        }
        @Override
        public int previousIndex() {
            return previousLoc;
        }
        @Override
        public void remove() {
            System.err.println("You can access only top element in stack!");
        }
        @Override
        public void set(E e) {
            System.err.println("You can access only top element in stack!");
        }
        @Override
        public void add(E e) {
            System.err.println("You can access only top element in stack!");
        }
    }
    public ListIterator<E> listIterator() {
         return new LinkedStack.StackListIterator();
    }
}
public class Activity12C {
    public static void main(String[] args) {
        LinkedStack<Integer> linkedStack = new LinkedStack<>(new Integer[]{1,2,3,4,5,6});
        while(linkedStack.size() > 0) {
            System.out.println(linkedStack.size() + "_linkedStack.peek(): " + linkedStack.peek());
            System.out.println(linkedStack.size() + "_linkedStack.pop(): " + linkedStack.pop());
            System.out.println(linkedStack.size() + "_After pop: " + linkedStack.toString() + "\n");
        }
        for (int i = 0; i < 6; i++) {
            linkedStack.push(i+25);
            System.out.println(i + "_After push" + "(" + (i+25) +  ")" + ": " + linkedStack.toString());
        }
        Iterator<Integer> iterator = linkedStack.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        iterator = linkedStack.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        ListIterator<Integer> listIterator = linkedStack.listIterator();
        while (listIterator.hasNext()){
            System.out.print(listIterator.nextIndex() + "_" +
                    listIterator.next() + " ");
        }
        System.out.println();

        while (listIterator.hasPrevious()){
            System.out.print(listIterator.previousIndex() + "_" +
                    listIterator.previous() + " ");
        }
        System.out.println();
    }
}