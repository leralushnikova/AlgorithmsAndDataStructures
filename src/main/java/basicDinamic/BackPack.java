package basicDinamic;

/**
 * Задача о рюкзаке
 */
public class BackPack {
    public static void main(String[] args) {
        int[] p = {5, 7, 9, 11, 13};
        int w = 19;

        System.out.println(maxWeight(p, w));
    }

    private static int maxWeight(int[] p, int w) {
        int n = p.length;
        int[][] a = new int[n + 1][w + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (j - p[i - 1] >= 0) {
                    a[i][j] = Math.max(a[i - 1][j], a[i - 1][j - p[i - 1]] + p[i - 1]);
                } else a[i][j] = a[i -1][j];
            }
        }

        return a[n][w];
    }
}
