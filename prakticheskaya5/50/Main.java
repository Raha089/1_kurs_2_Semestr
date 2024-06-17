import java.util.Scanner;

public class Calculator {

    private static double calculate(String equation) {
        String[] parts = equation.split(" ");
        double operand1 = Double.parseDouble(parts[0]);
        String operator = parts[1];
        double operand2 = Double.parseDouble(parts[2]);

        double result = 0;

        switch (operator) {
            case "+":
                result = operand1 + operand2; // Сложение
                break;
            case "-":
                result = operand1 - operand2; // Вычитание
                break;
            case "*":
                result = operand1 * operand2; // Умножение
                break;
            case "/":
                if (operand2 != 0) {
                    result = operand1 / operand2; // Деление
                } else {
                    throw new ArithmeticException("Деление на ноль не допускается.");
                }
                break;
            case "%":
                result = operand1 % operand2; // Остаток от деления
                break;
            case "//":
                result = Math.floor(operand1 / operand2); // Деление без остатка
                break;
            case "^":
                result = Math.pow(operand1, operand2); // Возведение в степень
                break;
            case "abs":
                result = Math.abs(operand1); // Модуль числа
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите уравнение (e.g., 2 + 3):");
        String equation = scanner.nextLine();

        try {
            double result = calculate(equation);
            System.out.println("Result: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Неверный ввод. Пожалуйста, введите корректное уравнение.");
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
