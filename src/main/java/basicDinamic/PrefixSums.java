package basicDinamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Префиксные суммы это метод, который позволяет быстро (за
O(1)) находить сумму элементов подмассива в массиве чисел.
 */
public class PrefixSums {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().trim().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int q = Integer.parseInt(firstLine[1]);

        String[] numbersStr = reader.readLine().trim().split(" ");
        int[] arr = new int[n];
        int[] prefixSums = new int[n + 1];

        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(numbersStr[i]);
            prefixSums[i + 1] = prefixSums[i] + arr[i];
        }

        long result = 0L;

        for (int i = 0; i < q; ++i) {
            String[] query = reader.readLine().trim().split(" ");
            int left = Integer.parseInt(query[0]);
            int right = Integer.parseInt(query[1]);
            result += prefixSums[right] - prefixSums[left - 1];
        }

        System.out.println(result);
    }
}
