import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(solvingNumbers());
    }

    private static String userPutString() {
        System.out.println("Введите строку из 4 чисел: ");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    private static int[] collectingArray(String userInput) {
        int[] arrayComparison = new int[4];
        for (int i = 0; i < arrayComparison.length; ++i) {
            arrayComparison[i] = Character.getNumericValue(userInput.charAt(i));
        }
        System.out.println(Arrays.toString(arrayComparison));
        return arrayComparison;
    }

    private static int[] makeNumber() {
        int[] arrayMake = new int[4];
        for (int i = 0; i < arrayMake.length; i++) {
            arrayMake[i] = (int) (Math.random() * 10);
        }
        return arrayMake;
    }

    private static String solvingNumbers() {
        String userInput = userPutString();
        int[] arrayComparison = collectingArray(userInput);
        int attempts = 20;
        String result = "";

        while (attempts > 0) {
            int[] arrayMake = makeNumber();
            int count = 0;

            for (int j = 0; j < arrayMake.length; ++j) {
                if (arrayMake[j] == arrayComparison[j]) ++count;
            }

            if (count == 4) {
                System.out.println("Вы отгадали");
                return Arrays.toString(arrayComparison);
            } else {
                attempts--;
                System.out.println("Вы не отгадали, попробуйте еще раз. Количество совпадений: " + count);
                if (attempts > 0) {
                    userInput = userPutString();
                    arrayComparison = collectingArray(userInput);
                }
            }
        }

        return "Вы потратили все 20 попыток. Правильный ответ: " + Arrays.toString(arrayComparison);
    }
}
