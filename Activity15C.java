import java.util.Arrays;

class Heap<T extends Comparable<T>> {

    private T[] heap;
    private int size;

    public Heap() {
        this.heap = (T[]) new Comparable[10];
        this.size = 0;
    }

    public void insert(T value) {
        if (size >= heap.length - 1) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
        size++;
        int index = size;
        heap[index] = value;

        while (index > 1 && heap[index].compareTo(heap[index / 2]) < 0) {
            swap(index, index / 2);
            index = index / 2;
        }
    }

    public T getMin() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap[1];
    }

    public T extractMin() {
        T min = getMin();
        heap[1] = heap[size];
        heap[size] = null;
        size--;
        int index = 1;
        while (true) {
            int leftChildIndex = index * 2;
            int rightChildIndex = index * 2 + 1;

            if (leftChildIndex > size) break;
            int smallerChildIndex = leftChildIndex;
            if (rightChildIndex <= size && heap[rightChildIndex].compareTo(heap[leftChildIndex]) < 0) smallerChildIndex = rightChildIndex;
            if (heap[index].compareTo(heap[smallerChildIndex]) < 0) break;
            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
        return min;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T[] toArray() {
        return Arrays.copyOfRange(heap, 1, size + 1);
    }

    public void decreaseKey(int index, T newValue) {
        if (index < 1 || index > size) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        if (heap[index].compareTo(newValue) < 0) {
            throw new IllegalArgumentException("New value is greater than current value");
        }
        insert(newValue);
    }

    private void swap(int index1, int index2) {
        T temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
}

public class Activity15C {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>();
        heap.insert(5);
        heap.insert(1);
        heap.insert(9);
        heap.insert(3);
        heap.insert(7);
        heap.insert(2);
        System.out.println("Minimum value: " + heap.getMin());
        System.out.println("Extracted minimum value: " + heap.extractMin());
        System.out.println("New minimum value: " + heap.getMin());
        heap.decreaseKey(2, 0);
        System.out.println("New minimum value after decrease key: " + heap.getMin());
        System.out.println("Elements in heap: " + Arrays.toString(heap.toArray()));
        System.out.println("Size of heap: " + heap.size());
        System.out.println("Is heap empty? " + heap.isEmpty());
    }
}
