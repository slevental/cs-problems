package sorting;

/**
 * Created by Stas on 10/27/15.
 */
public class HeapSort {

    public static void sort(int[] arr) {
        Heap heap = new Heap(arr);
        heap.sort();
    }

    private static class Heap {
        final int[] arr;
        int size;

        public Heap(int[] arr) {
            this.arr = arr;
            this.size = arr.length;
            for (int i = (arr.length) / 2; i >= 0; i--)
                heapify(i);
        }

        public void sort() {
            while (size > 0) {
                swap(0, --size);
                heapify(0);
            }
        }

        private void heapify(int i) {
            int largest = i;
            int l = i * 2 + 1;
            int r = l + 1;

            if (l < size && arr[l] > arr[largest]) largest = l;
            if (r < size && arr[r] > arr[largest]) largest = r;

            if (largest != i) {
                swap(largest, i);
                heapify(largest);
            }
        }

        private void swap(int i, int j) {
            int x = arr[i];
            arr[i] = arr[j];
            arr[j] = x;
        }
    }
}
