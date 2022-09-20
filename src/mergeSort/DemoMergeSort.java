package mergeSort;

class MergeSort {
    public void sort(int[] arr) {
        if (arr.length < 2)
            return;
        int len = arr.length;
        int mid = len / 2;
        int[] left = new int[mid];
        int[] right = new int[len - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid, j = 0; i < len; i++, j++) {
            right[j] = arr[i];
        }
        sort(left);
        sort(right);
        merge(left, right, arr);
    }

    private void merge(int[] left, int[] right, int[] arr) {
        int i = 0, j = 0, k = 0;
        int leftLen = left.length, rightLen = right.length;

        while (i < leftLen && j < rightLen) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
                j++;
                k++;
            }
        }
        while (i < leftLen) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < rightLen) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}

public class DemoMergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 9, 2, 5, 8, 6};
        MergeSort obj = new MergeSort();
        obj.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print((arr[i] + " "));
        }
    }
}
