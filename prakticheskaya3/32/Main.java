import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ThirtyTwo instance = new ThirtyTwo();
        int index = instance.inputUser();
        if (index < 10 || index > 100000) {
            System.out.println("Число должно быть от 10 до 100000");
        } else {
            int resFibonacci = instance.searchFibonacci(index);
            System.out.println("Результат: " + resFibonacci);
            int[] result = biggestCount(resFibonacci);
            System.out.println("Число: " + result[1] + ", Количество: " + result[0]);
        }
    }

    private int inputUser() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите индекс: ");
        return in.nextInt();
    }

    private int searchFibonacci(int index) {
        if (index < 2) return index;
        int work = 1, start = 1, res = 1;
        for (int i = 3; i <= index; ++i) {
            res = work + start;
            start = work;
            work = res;
        }
        return res;
    }

    private static int[] biggestCount(int resFibonacci) {
        String fibon = Integer.toString(resFibonacci);
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : fibon.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        char maxChar = ' ';
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount || (entry.getValue() == maxCount && entry.getKey() > maxChar)) {
                maxChar = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return new int[]{maxCount, Character.getNumericValue(maxChar)};
    }
}
