package bubbleSort;

class BubbleSort<T extends Comparable<? super T>> {
    public void sort(T[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    flag = false;
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (flag) {
                break;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print((arr[i] + " "));
        }
    }
}

public class DemoBubbleSort {
    public static void main(String[] args) {
        BubbleSort<Integer> obj = new BubbleSort<>();
        Integer[] arr = {9, 2, 3, 4, 5, 6, 7, 8};
        obj.sort(arr);
    }
}
