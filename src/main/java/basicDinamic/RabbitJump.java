package basicDinamic;

import java.util.Scanner;

/**
 * Задача о прыжке зайчика
 */
public class RabbitJump {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getSteps(n));
    }

    public static long getSteps(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        long[] steps = new long[n + 1];
        steps[0] = 1;
        steps[1] = 1;
        steps[2] = 1;
        steps[3] = 2;

        for (int i = 4; i < steps.length; i++) {
            steps[i] = steps[i - 1] + steps[i - 3] + steps[i - 4];
        }
        return steps[n];
    }
}
