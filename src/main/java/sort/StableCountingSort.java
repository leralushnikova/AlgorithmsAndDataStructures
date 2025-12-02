package sort;

import java.util.Arrays;
import java.util.Scanner;

public class StableCountingSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(stableCountingArr(arr)));
    }

    private static int maxDigital(int[] arr) {
        int max = 0;
        for (int j : arr) {
            if (max < j) max = j;
        }
        return max;
    }

    private static int[] stableCountingArr(int[] arr) {
        int max = maxDigital(arr);

        int[] count = countArr(arr, max);

        int[] outputArr = new int[arr.length];

        for (int i = arr.length - 1; i >= 0 ; i--) {
            int a = arr[i];
            int b = count[a] - 1;
            outputArr[b] = a;
            count[a]--;
        }

        return outputArr;
    }

    private static int[] countArr(int[] arr, int max) {
        int[] count = new int[max + 1];
        for (int j : arr) {
            count[j]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        return count;
    }
}
