public class HeapSort extends Sort {

    public HeapSort(Comparable[] A) {
        super(A);
    }

    /**
     * This algorithm takes advantage of the heap property,
     * putting the array into the form of a complete binary
     * tree with the max heap property as an invariant.
     * At all times, the largest element is on the top,
     * so as long as the max heap property is maintained by "sifting
     * elements down" (very similar to sifting sand and ending
     * up with the larger rocks). This gives us a number of calls to
     * siftDown proportional to N. Siftdown takes O(log2(N)), therefore
     * the whole alg takes O(N*log2(N)).
     */
    public void sort() {
        heapify();
        int end = A.length - 1;
        while (end > 0) {
            Comparable hold = A[end];
            A[end] = A[0];
            A[0] = hold;
            end = end - 1;
            siftDown(0, end);
        }      
    }

    private void heapify() {
        int count = A.length;
        int start = (count - 2) / 2;
        while (start >= 0) {
            siftDown(start, count - 1);
            start = start - 1;
        }
    }

    private void siftDown(int start, int end) {
        int root = start;
        int child;
        while (root * 2 + 1 <= end) {
            child = root * 2 + 1;
            int swap = root;
            if (A[swap].compareTo(A[child]) < 0)
                swap = child;
            if (child + 1 <= end && A[swap].compareTo(A[child+1]) < 0)
                swap = child + 1;
            if (swap == root) 
                return;
            else {
                Comparable hold = A[root];
                A[root] = A[swap];
                A[swap] = hold;
                root = swap;
            } 
        }
    }
}
