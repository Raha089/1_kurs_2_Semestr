import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] inputMass = inputMass();
        System.out.println(Arrays.toString(sortByDigitSum(inputMass)));
    }

    private static String[] inputMass() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите длину массива: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println("Введите числа в массив: ");
        String[] arrayMass = new String[length];
        for (int i = 0; i < length; i++) {
            arrayMass[i] = scanner.nextLine();
        }
        return arrayMass;
    }

    private static String[] sortByDigitSum(String[] inputMass) {
        Arrays.sort(inputMass, (a, b) -> Integer.compare(digitSum(a), digitSum(b)));
        return inputMass;
    }

    private static int digitSum(String str) {
        int sum = 0;
        for (char c : str.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        return sum;
    }
}
