public class BubbleSort extends Sort {

    public BubbleSort(Comparable[] A) {
        super(A);
    }

    /**
     * Sorts the elements by allowing elements to "bubble up".
     * The alg iterates through each successive pair, swapping them if the second is
     * shown to be smaller than the first.
     */
    public void sort() {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i].compareTo(A[i+1]) > 0) {
                    Comparable hold = A[i];
                    A[i] = A[i+1];
                    A[i+1] = hold;
                    swapped = true;
                }
            }   
        }
    }

    
}
