public class SelectionSort extends Sort {

    public SelectionSort(Comparable[] A) {
        super(A);
    }

    public void sort() {
        for (int i = 0; i < A.length - 1; i++) {
            int minIndex = i;
            Comparable minValue = A[minIndex];
            for (int j = i + 1; j < A.length; j++) {
                int comparison = minValue.compareTo(A[j]);
                if (comparison > 0) {
                    minIndex = j;
                    minValue = A[j];
                }
            }
            Comparable hold = A[i];
            A[i] = minValue;
            A[minIndex] = hold;
        }
    }
}
