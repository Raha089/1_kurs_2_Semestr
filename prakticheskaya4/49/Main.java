import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        int number = scanner.nextInt();
        int result = calculate(number);
        System.out.println(result);
    }

    private static int calculate(int number) {
        int a = 1, b = 0;
        if (number < 0) {
            return b;
        } else {
            return ruleThreeFour(number, a, b);
        }
    }

    private static int ruleThreeFour(int number, int a, int b) {
        if (number >= 0) {
            a = 2 * number * a;
            b = (2 * number + 1) * b;
            return ruleThreeFour(--number, b, a + b);
        } else {
            return ruleThreeFour(number, b, a + b);
        }
    }
}
