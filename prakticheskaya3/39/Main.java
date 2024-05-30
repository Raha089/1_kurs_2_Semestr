import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(changeText() + " ауч");
    }

    private static String inputStr() {
        System.out.println("Введите строку:");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    private static String changeText() {
        String inputStr = inputStr();
        StringBuilder str = new StringBuilder();
        char work = inputStr.charAt(0);
        
        for (int i = 1; i < inputStr.length(); i++) {
            if (inputStr.charAt(i) == ' ') {
                str.append(work).append(' ');
                if (i + 1 < inputStr.length()) {
                    work = inputStr.charAt(i + 1);
                    i++;
                }
            } else {
                str.append(inputStr.charAt(i));
            }
        }
        str.append(work);
        
        return str.toString();
    }
}
