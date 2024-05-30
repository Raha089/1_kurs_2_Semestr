import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ThirtySix program = new ThirtySix();
        String line = program.userPutString("Введите строку: ");
        String wordKey = program.userPutString("Введите слово ключ: ");
        char[] matrixWords = program.createMatrixWords();
        
        System.out.println("Результат работы: " + caesarsCipher(line, wordKey, matrixWords));
    }

    private String userPutString(String prompt) {
        System.out.println(prompt);
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    private char[] createMatrixWords() {
        char[] matrixWords = new char[32];
        for (int i = 0; i < 32; i++) {
            matrixWords[i] = (char) ('а' + i);
        }
        System.out.println(Arrays.toString(matrixWords));
        return matrixWords;
    }

    private static StringBuilder caesarsCipher(String line, String wordKey, char[] matrixWords) {
        StringBuilder result = new StringBuilder();
        int shift = calculateShift(wordKey, line, matrixWords);

        for (char ch : line.toCharArray()) {
            if (ch == ' ') {
                result.append(ch);
            } else {
                int index = getIndex(matrixWords, ch);
                int newIndex = (index + shift + matrixWords.length) % matrixWords.length;
                result.append(matrixWords[newIndex]);
            }
        }
        return result;
    }

    private static int calculateShift(String wordKey, String line, char[] matrixWords) {
        int keyIndex = getIndex(matrixWords, wordKey.charAt(0));
        int lineIndex = getIndex(matrixWords, line.charAt(0));
        return lineIndex - keyIndex;
    }

    private static int getIndex(char[] array, char ch) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ch) {
                return i;
            }
        }
        return -1;
    }
}
