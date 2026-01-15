package string_prefix;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Алгоритм Кнута-Морриса-Пратта. Сокращает время поиска префикса в строке до линейного времени.
 */
public class SearchPrefix {
    public static void main(String[] args) {

        String text =   "aabaabaaaaaabaabaabaabbaaab";
        String sample = "aabaab";

        System.out.println(Arrays.toString(KMPSearch(text, sample).toArray()));
    }

    static int[] prefixFunction(String sample) {
        int [] values = new int[sample.length()];
        for (int i = 1; i < sample.length(); i++) {
            int j = 0;
            while (i + j < sample.length() && sample.charAt(j) == sample.charAt(i + j)) {
                values[i + j] = Math.max(values[i + j], j + 1);
                j++;
            }
        }
        return values;
    }

    public static ArrayList<Integer> KMPSearch(String text, String sample) {
        ArrayList<Integer> found = new ArrayList<>();

        int[] prefixFunc = prefixFunction(sample);

        int i = 0;
        int j = 0;

        while (i < text.length()) {
            if (sample.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == sample.length()) {
                found.add(i - j);
                j = prefixFunc[j - 1];
            } else if (i < text.length() && sample.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = prefixFunc[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }

        return found;
    }
}
