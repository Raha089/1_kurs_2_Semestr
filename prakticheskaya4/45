import java.util.Scanner;

public class Main.java {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите год: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Введите корректное число.");
            return;
        }

        int years = scanner.nextInt();
        
        if (years < 1 || years > 9999) {
            System.out.println("Количество лет должно быть в диапазоне от 1 до 9999.");
        } else {
            System.out.println(years + " в римских числах равно " + convertToRoman(years));
        }
    }

    private static String convertToRoman(int years) {
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] romanValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder romanYears = new StringBuilder();
        
        for (int i = 0; i < romanValues.length; i++) {
            while (years >= romanValues[i]) {
                years -= romanValues[i];
                romanYears.append(romanSymbols[i]);
            }
        }
        return romanYears.toString();
    }
}
