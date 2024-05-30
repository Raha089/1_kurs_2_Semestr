import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String line = scanner.nextLine();

        System.out.print("Введите направление (справа/слева): ");
        String direction = scanner.nextLine();

        System.out.print("Введите сдвиг: ");
        int shift = scanner.nextInt();

        String result = caesarsCipher(line, direction, shift);
        System.out.println("Результат работы: " + result);
    }

    private static String caesarsCipher(String line, String direction, int shift) {
        StringBuilder result = new StringBuilder();
        char[] alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();
        int alphabetLength = alphabet.length;

        shift = shift % alphabetLength; // Normalize shift to avoid unnecessary cycles

        for (char ch : line.toCharArray()) {
            if (ch == ' ') {
                result.append(' ');
                continue;
            }

            int index = new String(alphabet).indexOf(ch);
            if (index == -1) {
                result.append(ch); // If character is not in the alphabet, append as is
                continue;
            }

            int newIndex;
            if (direction.equalsIgnoreCase("справа")) {
                newIndex = (index + shift) % alphabetLength;
            } else if (direction.equalsIgnoreCase("слева")) {
                newIndex = (index - shift + alphabetLength) % alphabetLength;
            } else {
                throw new IllegalArgumentException("Направление должно быть 'справа' или 'слева'");
            }
            result.append(alphabet[newIndex]);
        }
        return result.toString();
    }
}
