package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class RadixSort {
    private static final int MAX_N = (int) Math.pow(10, 3);
    private static final int MAX_LENGTH = 20;

    private static boolean isCorrectN(int arg) {
        return 0 <= arg && arg <= MAX_N;
    }

    private static boolean isCorrectLength(int arg) {
        return 0 <= arg && arg <= MAX_LENGTH;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        try {
            if (isCorrectN(N)) {
                int[] array = new int[N];
                for (int i = 0; i < N; i++) {
                    array[i] = Integer.parseInt(reader.readLine());
                }
                reader.close();

                if (isCorrectArray(array)) {
                    String s = lengthDigit(array);
                    System.out.println("Initial array:");
                    System.out.println(arrayString(array, s));
                    System.out.println("**********");

                    radixSort(array, s);
                    System.out.println("Sorted array:");
                    System.out.println(arrayString(array, s));
                }
            }

        } catch (NoSuchElementException e) {
            System.out.println("Initial array:");
            System.out.println();
            System.out.println("**********");
        }


    }

    public static void radixSort(int[] input, String s) {

        if(input.length == 0) return;
        List<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        boolean flag = false;
        int phase = 1;
        int divisor = 1;
        while (!flag) {
            flag = true;
            for (Integer i : input) {
                int tmp = i / divisor;
                buckets[tmp % 10].add(i);
                if (flag && tmp > 0) {
                    flag = false;
                }
            }
            if(flag) return;
            int a = 0;
            System.out.println("Phase " + phase);
            for (int b = 0; b < 10; b++) {
                System.out.print("Bucket " + b + ": ");
                StringBuilder str = new StringBuilder();
                for (Integer i : buckets[b]) {
                    str.append(String.format(s, i)).append(", ");
                    input[a++] = i;
                }
                if(str.length() > 2) str.deleteCharAt(str.length()-1).deleteCharAt(str.length()-1);
                if(buckets[b].isEmpty()) System.out.print("empty\n");
                else System.out.print(str + "\n");
                buckets[b].clear();
            }
            divisor *= 10;
            System.out.println("**********");
            phase++;
        }
    }
    private static boolean isCorrectArray(int[] array) {
        for (int i : array) {
            if(!isCorrectLength(String.valueOf(i).length())) return false;
        }
        return true;
    }

    private static String arrayString(int[] array, String s) {
        StringBuilder str = new StringBuilder();
        for (int i : array) {
            str.append(String.format(s, i)).append(", ");
        }
        str.deleteCharAt(str.length() -1).deleteCharAt(str.length() -1);
        return str.toString();
    }

    private static String lengthDigit(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int length = String.valueOf(max).length();
        return "%0" + length + "d";
    }
}