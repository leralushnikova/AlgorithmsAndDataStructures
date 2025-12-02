package heap;

import java.util.Scanner;

public class test1 {
    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] heapArray = new int[size];
        int swap = 0;

        for (int i = 0; i < size; i++) {
            heapArray[i] = scanner.nextInt();
            swap += displaceUp(heapArray, i);
        }

        System.out.println(swap + "\n" + stringBuilder);

    }

    private static int displaceUp(int[] heapArray, int index) {
        int swap = 0;
        int parentIndex = (index - 1) / 2;
        int bottom = heapArray[index];
        while (index > 0 && heapArray[parentIndex] > bottom) {
            swap++;
            stringBuilder.append(index + 1).append(" ").append(parentIndex + 1).append("\n");
            heapArray[index] = heapArray[parentIndex];
            index = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        heapArray[index] = bottom;
        return swap;
    }
}
