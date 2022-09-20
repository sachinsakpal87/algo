package quickSort;

class QuickSort {
    public void sort(int[] arr, int start, int end) {
        if (start > end)
            return;
        int pindex;
        pindex = partition(arr, start, end);
        sort(arr, start, pindex - 1);
        sort(arr, pindex + 1, end);
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pindex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[pindex];
                arr[pindex] = temp;
                pindex++;
            }
        }
        int temp = arr[pindex];
        arr[pindex] = arr[end];
        arr[end] = temp;
        return pindex;
    }
}

public class DemoQuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 9, 2, 5, 8, 6};
        QuickSort obj = new QuickSort();
        obj.sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print((arr[i] + " "));
        }
    }
}
