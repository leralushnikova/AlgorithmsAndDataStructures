package string_hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * z-функция.
 */
public class ZFunction {
    public static void main(String[] args) throws IOException {
        /*
        Пример ввода: abracadabra
        вывода: 0 0 0 1 0 1 0 4 0 0 1
         */
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String str = reader.readLine().trim();
            int[] z = computeZFunction(str);

            StringBuilder output = new StringBuilder();
            for (int num : z) {
                output.append(num).append(" ");
            }
            System.out.println(output.toString().trim());
        }
    }

    private static int[] computeZFunction(String str) {
        int n = str.length();
        int[] z = new int[n];
        z[0] = 0;

        int left = 0;
        int right = 0;

        for (int i = 1; i < n; i++) {
            if (i <= right) {
                z[i] = Math.min(right - i + 1, z[i - left]);
            }
            while (i + z[i] < n && str.charAt(z[i]) == str.charAt(i + z[i])) {
                z[i]++;
            }
            if (i + z[i] - 1 > right) {
                left = i;
                right = i + z[i] - 1;
            }
        }

        return z;
    }
}
