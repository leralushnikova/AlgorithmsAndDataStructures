package binarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 56, 72};
        int key = 38;

        int result = binarySearch(sortedArray, key);

        if (result == -1) {
            System.out.println("Элемент не найден.");
        } else {
            System.out.println("Элемент найден на позиции: " + result);
        }
    }

    private static int binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(array[mid] == key) return mid;
            else if(array[mid] < key)  left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }
}
