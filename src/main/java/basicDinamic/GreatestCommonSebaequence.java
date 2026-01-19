package basicDinamic;

import java.util.Scanner;

/**
Наибольшая общая подпоследовательность
Sample Input:
2
6
5 1 5 7 5 9
5
1 7 2 3 9
2
1000000000 1
2
1 1000000000
Sample Output:
3
1
 */
public class GreatestCommonSebaequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < test; i++) {
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

            stringBuilder.append(gcs(a, b, n, m)).append("\n");
        }
        System.out.println(stringBuilder.toString().trim());
    }

    public static int gcs(int[] a, int[] b, int n, int m) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(a[j - 1] != b[i - 1]) dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                else dp[i][j] = dp[i - 1][j - 1] + 1;
            }
        }

        return dp[m][n];
    }
}