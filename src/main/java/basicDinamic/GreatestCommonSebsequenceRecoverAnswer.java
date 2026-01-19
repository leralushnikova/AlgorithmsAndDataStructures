package basicDinamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 Наибольшая общая подпоследовательность с восстановлением ответа
 Ввод
 3
 1 2 3
 3
 2 3 1

вывод
 2 3

 Ввод
 3
 1 2 3
 3
 3 2 1

 вывод
 1

 Ввод
 5
 1 2 3 4 10
 5
 3 4 1 2 10
 Вывод
 1 2 10

 */
public class GreatestCommonSebsequenceRecoverAnswer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int j = 0; j < n; j++) {
            a[j] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int j = 0; j < m; j++) {
            b[j] = scanner.nextInt();
        }

        List<Integer> subsequence = maxSubsequence(a, b, n, m);

        for (int i = subsequence.size() - 1; i >= 0 ; i--) {
            System.out.print(subsequence.get(i) + " ");
        }
    }

    public static List<Integer> maxSubsequence(int[] a, int[] b, int n, int m) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(a[j - 1] != b[i - 1]) dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                else dp[i][j] = dp[i - 1][j - 1] + 1;
            }
        }

        List<Integer> subsequence = new ArrayList<>();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if(b[i - 1] == a[j - 1]) {
                subsequence.add(a[j - 1]);
                i--;
                j--;
            } else if(dp[i - 1][j] > dp[i][j - 1]) i--;
            else j--;
        }

        return subsequence;
    }
}