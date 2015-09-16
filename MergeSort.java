public class MergeSort extends Sort {

    public MergeSort(Comparable[] A) {
        super(A);
    }

    /**
     * This algorithm consists of two subroutines: splitThenSort and merge.
     * The higher level picture of what it's doing is reducing the problem of sorting a large
     * array into sorting two arrays of smaller size. As the problem of sorting naively is O(N*N),
     * this reduction drastically reduces the complexity of the whole problem, as merging two sorted  
     * lists can be done in linear time.
     */
    public void sort() {
        Comparable[] B = new Comparable[A.length];
        splitThenSort(0, A.length, B);
    }

    /** 
     * This part of the algorithm partitions the set into its two halves, which will then be merged.
     * The key insight here is that any list of one element is already sorted.
     */
    private void splitThenSort(int begin, int end, Comparable[] B) {
        if (end - begin < 2)
            return;
        int middle = (end + begin) / 2;
        splitThenSort(begin, middle, B);
        splitThenSort(middle, end, B);
        merge(begin, middle, end, B);
        for (int i = begin; i < end; i++) {
            A[i] = B[i];
        }
    }
    
    /**
     * In time THETA(end - begin - 1), this procedure merges two lists.
     * The right list begins at begin and ends before middle,
     * while the left list begins at middle and ends before end.
     */
    private void merge(int begin, int middle, int end, Comparable[] B) {
        int iLeft = begin;
        int iRight = middle;
        for (int j = begin; j < end; j++) {
            if (iLeft < middle && (iRight >= end || A[iLeft].compareTo(A[iRight]) <= 0)) {
                B[j] = A[iLeft];
                iLeft++;
            } else {
                B[j] = A[iRight];
                iRight++;
            }
        }
    }
}
