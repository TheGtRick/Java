import java.util.Iterator;
import java.util.NoSuchElementException;
abstract class MyAbstractList<E> {
    Node<E> head;
    Node<E> tail;
    int size = 0;
    public MyAbstractList(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            addLast(objects[i]);
    }
    public abstract boolean isEmpty();
    public abstract int size();
    public abstract void clear();
    public abstract void print();
    public abstract E get(int index);
    public abstract E getFirst();
    public abstract E getLast();
    public abstract void addFirst(E e);
    public abstract void addLast(E e);
    public abstract void add(int index, E e);
    public abstract E removeFirst();
    public abstract E removeLast();
    public abstract E remove(int index);
    public abstract boolean contains(E e);
    public abstract int indexOf(E e);
    public abstract int lastIndexOf(E e);
    public abstract E set(int index, E e);
    public Iterator<E> iterator(){
        return new LLIterator();
    }
    private class LLIterator implements Iterator<E> {
        boolean canRemove = false;
        int previousLoc = -1;
        private Node<E> current = head;
        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public E next() {
            if (hasNext()) {
                E data = current.data;
                current = current.next;
                previousLoc++;
                canRemove = true;
                return data;
            }
            throw new NoSuchElementException("There are no next element");
        }
        @Override
        public void remove() {
            if (!canRemove) {
                throw new IllegalStateException("You can't delete element before first next() method call");
            }
            MyAbstractList.this.remove(previousLoc);
            canRemove = false;
        }
    }
}
class Node<E> {
    E data;
    Node<E> next;
    public Node(E data) {
        this.data = data;
    }
}
class MyLL<E> extends MyAbstractList<E> {
    public MyLL(E[] objects) {
        super(objects);
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }
    @Override
    public void print() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    @Override
    public E get(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    @Override
    public E getFirst() {
        if(size == 0) return null;
        else return head.data;
    }
    @Override
    public E getLast() {
        if(size == 0) return null;
        else return tail.data;
    }
    @Override
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
        size++;
    }
    @Override
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }
    @Override
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index == size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node<E> newNode = new Node<>(e);
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }
    @Override
    public E removeFirst() {
        if (head == null) {
            return null;
        }
        E removedData= head.data;
        head = head.next;
        size--;
        if (head == null) {
            tail = null;
        }
        return removedData;
    }
    @Override
    public E removeLast() {
        if (tail == null) {
            return null;
        }
        E removedData = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            Node<E> current = head;
            while (current.next != tail) {
                current = current.next;
            }
            tail = current;
            tail.next = null;
        }
        size--;
        return removedData;
    }
    @Override
    public E remove(int index) {
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = temp.next;
            size--;
            return temp.data;
        }
    }
    @Override
    public boolean contains(E e) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    @Override
    public int indexOf(E e) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(e)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }
    @Override
    public int lastIndexOf(E e) {
        Node<E> current = head;
        int lastIndex = -1;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(e)) {
                lastIndex = i;
            }
            current = current.next;
        }
        return lastIndex;
    }
    @Override
    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E oldValue = current.data;
        current.data = e;
        return oldValue;
    }
}
class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
        this.data = data;
    }
}
public class Activity12 {
    public static void main(String[] args) {
        MyLL myLL = new MyLL(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 5, 9});
        System.out.println("myLL.size(): " + myLL.size());
        System.out.println("myLL.isEmpty(): " + myLL.isEmpty());
        myLL.print();
        System.out.println("myLL.get(2): " + myLL.get(2));
        System.out.println("myLL.getFirst(): " + myLL.getFirst());
        System.out.println("myLL.getLast(): " + myLL.getLast());
        myLL.add(2, 222);
        System.out.println("After : add(2, 222): " );
        myLL.print();
        myLL.addFirst(111);
        myLL.addFirst( 999);
        System.out.println("After : addFirst(111) and addFirst(999): " );
        myLL.print();
        System.out.println("myLL.remove(2): " + myLL.remove(2));
        System.out.println("myLL.removeFirst(): " + myLL.removeFirst());
        System.out.println("myLL.removeLast(): " + myLL.removeLast());
        myLL.print();
        System.out.println("myLL.contains(111): " + myLL.contains(111));
        System.out.println("myLL.contains(5): " + myLL.contains(5));
        System.out.println("myLL.indexOf(5): " + myLL.indexOf(5));
        System.out.println("myLL.lastIndexOf(5): " + myLL.lastIndexOf(5));
        System.out.println("myLL.lastIndexOf(88): " + myLL.lastIndexOf(88));
        System.out.println("myLL.set(2, 22): " + myLL.set(2, 22));
        System.out.println("myLL.set(1, 3333): " + myLL.set(1, 3333));
        Iterator<Integer> iterator = myLL.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        myLL.clear();
        System.out.println("myLL.isEmpty(): " + myLL.isEmpty());
        myLL.print();
    }
}