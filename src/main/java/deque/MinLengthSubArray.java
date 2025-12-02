package deque;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MinLengthSubArray {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(findMinLength(arr, k));
    }

    private static int findMinLength(int[] arr, int k) {
        if(arr.length == 0 || k <= 0) return 0;

        int start = 0;
        int end = 0;
        int answer = Integer.MAX_VALUE;

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        while (end < arr.length) {

            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] <= arr[end]) {
                maxDeque.pollLast();
            }

            maxDeque.offerLast(end);

            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] >= arr[end]) {
                minDeque.pollLast();
            }

            minDeque.offerLast(end);

            while (start <= end && arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()] >= k) {
                answer = Math.min(answer, end - start + 1);

                if(maxDeque.peekFirst() == start) maxDeque.pollFirst();
                if(minDeque.peekFirst() == start) minDeque.pollFirst();

                start++;
            }

            end++;
        }

        return answer != Integer.MAX_VALUE ? answer : 0;
    }
}
