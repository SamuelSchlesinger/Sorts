import java.util.Random;

public class SortClient {

    private static Random rand = new Random();
 
    public static void main(String[] args) {
        Sort[] test;
	String[] test_types;
	int N;
        if (args.length == 0) {
            System.out.println("Usage: java SortClient N [-option]");
            System.out.println("options: -i (insertion sort)");
            System.out.println("         -b (bubble sort)");
            System.out.println("         -m (merge sort)");
            System.out.println("         -s (selection sort");
            System.out.println("         -h (heap sort)");
            return;
        } else {
            Integer[] A =  random(Integer.parseInt(args[0]));
            if (args.length > 1) {
	        test = new Sort[args.length - 1];
		test_types = new String[args.length - 1];
		for (int i = 1; i < args.length; i++) {
                    char c = args[i].charAt(1);
                    switch (c) {
		        case 'i':
		            test[i-1] = new InsertionSort(copy(A));
			    test_types[i-1] = "Insertion";
			    break;
		        case 'b':
		            test[i-1] = new BubbleSort(copy(A));
			    test_types[i-1] = "Bubble";
			    break;
			case 'm':
		            test[i-1] = new MergeSort(copy(A));
			    test_types[i-1] = "Merge";
			    break;
		        case 's':
		            test[i-1] = new SelectionSort(copy(A));
			    test_types[i-1] = "Selection";
			    break;
		        case 'h':
		            test[i-1] = new HeapSort(copy(A));
			    test_types[i-1] = "Heap";
			    break;
			default:
			    test[i-1] = new HeapSort(copy(A));
			    test_types[i-1] = "Heap";
			    break;
                    }
                }
            } else {
	        test = new Sort[1];
		test_types = new String[1];
                test[0] = new HeapSort(copy(A));
		test_types[0] = "Heap";
            }
	}
	for (int i = 0; i < test.length; i++) {
            long start_time = System.currentTimeMillis(); 
	    test[i].sort();
	    long end_time = System.currentTimeMillis();
	    if (test[i].isSorted()) {
                System.out.printf("%s sort passed in %d milliseconds.\n", test_types[i], (end_time - start_time));
	    } else {
	        System.out.println("Sort test failed!"); 
	    }
	}
    }

    private static Integer[] random(int N) {   
        Integer[] A = new Integer[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = rand.nextInt(); 
        }
        return A;
    }

    private static Integer[] copy(Integer[] array) {
        Integer[] B = new Integer[array.length];
	for (int i = 0; i < array.length; i++) {
            int a = array[i];
	    B[i] = a;
	}
	return B;
    }
}
