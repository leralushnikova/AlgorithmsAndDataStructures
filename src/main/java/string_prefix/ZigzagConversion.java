package string_prefix;

/**
 * Зигзаг паттерн
 */
public class ZigzagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int n = 3;
        System.out.println(convert(s, n));
    }
    public static String convert(String s, int numRows) {
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            if(numRows != 1) currentRow += goingDown ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();

    }
}
