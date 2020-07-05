package sorting;

public class SortTools {
    public static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isLess(Comparable[] arr, int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }
    
    public static boolean isSortedAsc(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (isLess(arr, i + 1, i))
                return false;
        }
        return true;
    }


    // An optimised version of MergeSort using N/2 Space instead of N
    public static void mergeSortSpaceOptimization(Comparable[] array) {
        Comparable[] tempArray = new Comparable[array.length / 2 + array.length
                % 2]; // Adds 1 to temp array if length is odd
        mergeSplit(array, tempArray, 0, array.length - 1);
    }

    private static void mergeSplit(Comparable array[], Comparable aux[],
            int low, int high) {
        if (high <= low)
            return;
        int mid = low + (high - low) / 2;
        mergeSplit(array, aux, low, mid);
        mergeSplit(array, aux, mid + 1, high);
        mergeSpaceOptimized(array, aux, low, mid, high);
    }

    private static void mergeSpaceOptimized(Comparable[] array,
            Comparable auxArray[], int low, int mid, int high) {
        for (int i = low, j = 0; i <= mid; i++) {
            auxArray[j++] = array[i]; // Copies left half of array into Temp
                                      // Array
        }
        // if (!SortTools.isSortedAsc(auxArray)) throw new
        // RuntimeException("Temp Array is not Sorted!");
        int size = mid - low + 1;
        int i = 0, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i >= size)
                array[k] = array[j++];
            else if (j > high)
                array[k] = auxArray[i++];
            else if (SortTools.isLess(array[j], auxArray[i]))
                array[k] = array[j++];
            else
                array[k] = auxArray[i++];
        }
    }

    private static boolean isLess(Comparable num1, Comparable num2) {
        return num1.compareTo(num2) < 0;
    }

    public void shuffleLinkedList(Node head) {
        Node it1 = head, it2 = head;

        // Find mid Node in linked-list
        while (it2 != null && it2.next != null) {
            it2 = it2.next.next;
            if (it2 == null) {
                break; // Prevents first Iterator from moving to Next, just to
                       // break just before mid Element.
            }
            it1 = it1.next;
        }

        Node i = head;
        Node j = it1.next; // Points to middle Element
        it1.next = null; // Disconnects first half from mid element

        // Now have 2 separate lists.
        // while(i!=null || j!=null){
        // Random random = new Random();
        // int rand = random.nextInt(2);
        //
        // }
        Node it = head;
        while (it != null) {
            System.out.println(it.value + " ");
            it = it.next;
        }

    }

    public static void shellSort(Comparable[] arr) {
        int length = arr.length;
        int gap = 1;
        while (gap < length / 3)
            gap = 3 * gap + 1;

        while (gap >= 1) {
            for (int i = gap; i < length; i++) {
                for (int j = i; j >= gap && isLess(arr, j, j - gap); j -= gap) {
                    swap(arr, j, j - gap);
                }
            }
            gap = gap / 3;
        }
    }

//    public static void main(String[] args) {
//        Node x3 = new Node(3);
//        Node x4 = new Node(4);
//        Node x5 = new Node(5);
//        Node x6 = new Node(5);
//        Node x7 = new Node(7);
//        Node x8 = new Node(8);
//        Node x9 = new Node(9);
//        Node x10 = new Node(10);
//
//        x3.next = x4;
//        x4.next = x5;
//        x5.next = x6;
//        x6.next = x7;
//        x7.next = x8;
//        x8.next = x9;
//        x9.next = x10;
//    }
}

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }
}
