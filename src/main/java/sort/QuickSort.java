package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {
    private static final int MAX_N = (int) Math.pow(10, 6);
    private static final int MAX_DiGIT = (int) Math.pow(10, 9);
    private static final int MIN_DIGIT = -(int) Math.pow(10, 9);

    private static boolean isCorrectN(int arg) {
        return 0 <= arg && arg <= MAX_N;
    }

    private static boolean isCorrectDigit(int arg) {
        return MIN_DIGIT <= arg && arg <= MAX_DiGIT;
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());
            String str = reader.readLine();

            int[] array = digitsSplit(str);

            if (isCorrectN(N) && (N == array.length) && isCorrectArray(array)) {
                int low = 0;
                int high = array.length - 1;
                quickSort(array, low, high);
                for (int i = 0; i < N; i++) {
                    System.out.print(array[i] + " ");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println();
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if(array.length == 0) return;
        if(low >= high) return;

        int middle = (int) (Math.random() * ((high - low) + 1)) + low;
        int border = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (array[i] < border) i++;
            while (array[j] > border) j--;

            if (i <= j) {
                int swap = array[i];
                array[i] = array[j];
                array[j] = swap;
                i++;
                j--;
            }
        }

        if(low < j) quickSort(array, low, j);
        if(high > i) quickSort(array, i, high);
    }

    private static int[] digitsSplit(String s) {
        String[] strings = s.split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        return nums;
    }

    private static boolean isCorrectArray(int[] array) {
        for (int i : array) {
            if(!isCorrectDigit(i)) return false;
        }
        return true;
    }
}
