public abstract class Sort {

    protected Comparable[] A;

    public Sort(Comparable[] A) {
        this.A = A;
    } 

    public abstract void sort(); // sorts elements of array in ascending order

    public boolean isSorted() {
        if (A == null) return false;
        for (int i = 1; i < A.length; i++) {
            if (A[i].compareTo(A[i-1]) < 0)
                return false;
        }        
        return true;
    }
}
