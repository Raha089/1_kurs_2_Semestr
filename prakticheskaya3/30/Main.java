import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину ряда: ");
        int numbers = scanner.nextInt();

        System.out.print("Введите стартовое число: ");
        int start = scanner.nextInt();

        System.out.println("Результат работы: " + scriptMath(numbers, start));
    }

    private static String scriptMath(int numbers, int start) {
        int sum = 0;
        int number = numbers;
        
        StringBuilder result = new StringBuilder();
        String numberString = Integer.toString(start);
        
        for (int i = 0; i < numberString.length(); i++) {
            int digit = Character.getNumericValue(numberString.charAt(i));
            sum += Math.pow(digit, number);
            result.append(digit).append("^").append(number);
            if (i + 1 != numberString.length()) {
                result.append("+");
            }
            number++;
        }

        result.append("=").append(start).append("*").append(numbers);
        return result.toString();
    }
}
