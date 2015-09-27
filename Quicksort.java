public class Quicksort extends Sort {
    public Quicksort(Comparable[] A) {
        super(A);
    }

    public void sort() {
        qsort(0, A.length);
    }

    private void qsort(int lo, int hi) {
        if (lo + 1 < hi) {
            if (hi == lo + 2) {
                twosort(lo, hi - 1);
            } else {
                int p = partition(lo, hi);
                qsort(lo, p);
                qsort(p+1,hi);
            }
        }
    }

    private void twosort(int i, int j) {
        if (A[i].compareTo(A[j]) > 0) {
            Comparable hold = A[j];
            A[j] = A[i];
            A[i] = hold;
        }
    }

    private int selectPivot(int low, int high) {
        int m = (low + high - 1) / 2;
        if (A[high - 1].compareTo(A[low]) < 0 && A[high - 1].compareTo(A[m]) > 0) {
            return high - 1;
        } else if (A[m].compareTo(A[low]) < 0 && A[m].compareTo(A[high - 1]) > 0) {
            return m;
        }
        return low;
    }

    private int partition(int low, int high) {  
        int i = low;
        int j = high;
        int p = selectPivot(low, high);
        if (p != low) {
            Comparable hold = A[low];
            A[low] = A[p];
            A[p] = A[low];
        }
        Comparable pivot = A[low];
        while (true) {
            while (pivot.compareTo(A[++i]) > 0) {
                if (i == high - 1) break;
            }

            while (pivot.compareTo(A[--j]) < 0) {
                if (j == low) break;
            }
            if (i >= j) break;
            Comparable hold = A[i];
            A[i] = A[j];
            A[j] = hold;
        }
        Comparable hold = A[low];
        A[low] = A[j];
        A[j] = hold;
        return j;
    }
}
