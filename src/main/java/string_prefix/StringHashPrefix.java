package string_prefix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Алгоритм хеширования префикса
 */
public class StringHashPrefix {
    private static final int p = 1000000007;
    private static final int x_ = 257;
    private static int MIN_LENGTH = Integer.MAX_VALUE;

    /*
    Пример ввода: bcabcab
    вывода: 3
    ввод: zzz
    вывод:  1
     */
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String prefix = reader.readLine().trim();
            if (!prefix.isEmpty() && !prefix.isBlank()) {

                int n = prefix.length();

                int[] h = new int[n + 1];
                int[] x = new int[n + 1];
                x[0] = 1;

                for (int i = 0; i < n; i++) {
                    h[i + 1] = (int) (((long) h[i] * x_ + prefix.charAt(i)) % p);
                    x[i + 1] = (int) (((long) x[i] * x_) % p);
                }

                System.out.println(findMinOriginalLength(prefix, h, x));
            } else System.out.println(0);
        }
    }

    private static int findMinOriginalLength(String prefix, int[] h, int[] x) {
        if(prefix.length() == 1) return 1;
        int lengthPrefix = prefix.length() - 1;
        for (int i = 0; i < lengthPrefix; i++) {
            int fromB = lengthPrefix - i;
            char start = prefix.charAt(0);
            char end = prefix.charAt(lengthPrefix - i);
            if(start == end && isEqual(0, fromB, i + 1, h, x)){
                MIN_LENGTH = fromB;
            }
        }
        if(MIN_LENGTH == Integer.MAX_VALUE) return prefix.length();
        return MIN_LENGTH;
    }

    public static boolean isEqual(int from1, int from2, int slen, int[] h, int[] x) {
        long hash1 = (h[from1 + slen] - ((long) h[from1] * x[slen]) % p + p) % p;
        long hash2 = (h[from2 + slen] - ((long) h[from2] * x[slen]) % p + p) % p;
        return hash1 == hash2;
    }
}
