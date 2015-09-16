public class InsertionSort extends Sort {

    public InsertionSort(Comparable[] A) {
        super(A);
    }

    public void sort() {
        for (int i = 1; i < A.length; i++) {
            Comparable current = A[i];
            for (int j = i-1; j >= 0; j--) {
                if (current.compareTo(A[j]) < 0) {
                    Comparable hold = A[j];
                    A[j] = current;
                    A[j+1] = hold;
                } else break;  
            }
        }
    }


    public boolean isSorted() {
        if (A == null) 
            return false;
        else
            for (int i = 1; i < A.length; i++) {
                if (A[i].compareTo(A[i-1]) < 0)
                    return false;
            }
        return true;
    }
}
