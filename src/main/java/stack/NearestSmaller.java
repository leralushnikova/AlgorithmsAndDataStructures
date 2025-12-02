package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/*
 Минимум в окне через Стек
 */
public class NearestSmaller {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        int[] arr = array(reader.readLine());
        int[] resultLeft = findNearestSmallerLeft(arr);
        int[] resultRight = findNearestSmallerRight(arr);
        for (int i = 0; i < size; i++) {
            System.out.println(resultLeft[i] + " " + resultRight[i]);
        }
    }

    public static int[] array(String str) {
        String[] strings = str.split(" ");
        return Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
    }

    public static int[] findNearestSmallerLeft(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Удаляем из стека все элементы, которые больше текущего
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            // Если стек пуст, значит, нет меньшего слева элемента
            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                // Ближайший меньший элемент — это вершина стека
                result[i] = stack.peek();
            }
            // Добавляем текущий элемент в стек
            stack.push(arr[i]);
        }
        return result;
    }

    public static int[] findNearestSmallerRight(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }
        return result;
    }
}