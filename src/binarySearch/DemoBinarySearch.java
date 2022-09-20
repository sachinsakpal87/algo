package binarySearch;

class BinarySearch {
    public boolean search(int[] arr, int start, int end, int value) {
        if (start > end)
            return false;
        int mid = (end-start / 2); //This is imp as we are using recursion so index changes
        if (value == arr[mid]) {
            return true;
        } else {
            return (value < arr[mid])
                    ? search(arr, start, mid - 1, value)
                    : search(arr, mid + 1, end, value);
        }
    }
}

public class DemoBinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 8};
        BinarySearch obj = new BinarySearch();
        boolean flag = false;
        flag = obj.search(arr, 0, arr.length - 1, 1);
        System.out.println(flag);

        flag = obj.search(arr, 0, arr.length - 1, 8);
        System.out.println(flag);

        flag = obj.search(arr, 0, arr.length - 1, 5);
        System.out.println(flag);

        flag = obj.search(arr, 0, arr.length - 1, 12);
        System.out.println(flag);
    }
}
