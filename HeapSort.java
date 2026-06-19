import java.util.ArrayList;

public class HeapSort {

    static ArrayList<Integer> heap = new ArrayList<>();

    public static void heapify(int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < size && heap.get(left) > heap.get(largest)) {
            largest = left;
        }

        if (right < size && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            int temp = heap.get(i);
            heap.set(i, heap.get(largest));
            heap.set(largest, temp);

            heapify(largest, size);
        }
    }

    public static void heapSort() {
        int n = heap.size();

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(i, n);
        }

        // Extract elements one by one
        for (int i = n - 1; i > 0; i--) {

            // Swap root with last element
            int temp = heap.get(0);
            heap.set(0, heap.get(i));
            heap.set(i, temp);

            // Heapify reduced heap
            heapify(0, i);
        }
    }

    public static void main(String[] args) {

        heap.add(1);
        heap.add(2);
        heap.add(4);
        heap.add(5);
        heap.add(3);

        System.out.println("Before Sorting:");
        System.out.println(heap);

        heapSort();

        System.out.println("After Sorting:");
        System.out.println(heap);
    }
}