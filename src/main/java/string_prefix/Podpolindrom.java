package string_prefix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Алгоритм Манакера. Нахождение всех полиндромных подстрок
 */
public class Podpolindrom {
    public static int countPalindromicSubstrings(String s) {
        StringBuilder t = new StringBuilder("^");
        for (int i = 0; i < s.length(); i++) {
            t.append("#").append(s.charAt(i));
        }
        t.append("#$");

        int n = t.length();
        int[] p = new int[n];
        int center = 0, right = 0;
        int count = 0;

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;

            if (right > i) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            while (t.charAt(i + p[i] + 1) == t.charAt(i - p[i] - 1)) {
                p[i]++;
            }

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            count += (p[i] + 1) / 2;
        }

        return count;
    }

    /*
    Пример ввода: aaa
    вывода: 6
    ввод: aba
    вывод: 4
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine().trim();

            int result = countPalindromicSubstrings(input);
            System.out.println(result);
        }
    }
}