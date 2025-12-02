package heap;

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap(10);

        heap.printHeap();

        heap.insertNode(5);
        heap.insertNode(6);
        heap.insertNode(1);
        heap.insertNode(10);
        heap.insertNode(5);
        heap.insertNode(12);

        heap.printHeap();
    }
}
