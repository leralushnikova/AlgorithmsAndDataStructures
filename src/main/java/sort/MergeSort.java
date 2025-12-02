package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {
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

            int M = Integer.parseInt(reader.readLine());
            String str1 = reader.readLine();

            int[] arrayA = digitsSplit(str);
            int[] arrayB = digitsSplit(str1);

            if (isCorrectN(N) && isCorrectN(N) && isCorrectArray(arrayA) && isCorrectArray(arrayB)) {
                int[] newArray = new int[N+M];
                merge(newArray, arrayA, arrayB);
                for (int j : newArray) {
                    System.out.print(j + " ");
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("0");
        }
    }

    private static int[] digitsSplit(String s) {
        String[] strings = s.split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        return nums;
    }

    private static void merge(int[] array, int[] a, int[] b) {
        int left = a.length;
        int right = b.length;
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (a[i] < b[j]) {
                array[k] = a[i];
                i++;
            } else {
                array[k] = b[j];
                j++;
            }
            k++;
        }
        for (int aa = i; aa < left; aa++) {
            array[k++] = a[aa];
        }
        for (int bb = j; bb < right; bb++) {
            array[k++] = b[bb];
        }
    }

    private static boolean isCorrectArray(int[] array) {
        for (int i : array) {
            if(!isCorrectDigit(i)) return false;
        }
        return true;
    }
}