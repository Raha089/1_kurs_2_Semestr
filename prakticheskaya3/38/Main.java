import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(everyThree());
    }

    private static ArrayList<Integer> userArray() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество участников: ");
        int longArray = in.nextInt();
        
        ArrayList<Integer> list = new ArrayList<>(longArray);
        for (int i = 0; i < longArray; i++) {
            list.add(i + 1);
        }
        System.out.println(list);
        return list;
    }

    private static int userPutStart() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите номер первого участника: ");
        return in.nextInt();
    }

    private static String everyThree() {
        ArrayList<Integer> userArray = userArray();
        int userPutStart = userPutStart() - 1; // adjust for 0-based index
        ArrayList<Integer> copyArray = new ArrayList<>();

        while (!userArray.isEmpty()) {
            userPutStart = (userPutStart + 2) % userArray.size();
            copyArray.add(userArray.remove(userPutStart));
            System.out.println(userArray + " результат " + copyArray);
        }

        return copyArray.get(copyArray.size() - 1) + " победил. Результат: " + copyArray;
    }
}
