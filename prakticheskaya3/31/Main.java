import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        int kilometers = 175;
        List<Integer> arrayCity = List.of(50, 55, 57, 58, 60);
        System.out.println("Результат работы: " + chooseBestSum(kilometers, arrayCity, 3));
    }

    private static int chooseBestSum(int kilometers, List<Integer> arrayCity, int numCities) {
        return findBestSum(arrayCity, numCities, 0, kilometers, 0);
    }

    private static int findBestSum(List<Integer> cities, int numCities, int start, int maxKilometers, int currentSum) {
        if (numCities == 0) {
            return currentSum <= maxKilometers ? currentSum : 0;
        }
        int bestSum = 0;
        for (int i = start; i <= cities.size() - numCities; i++) {
            int newSum = findBestSum(cities, numCities - 1, i + 1, maxKilometers, currentSum + cities.get(i));
            if (newSum > bestSum) {
                bestSum = newSum;
            }
        }
        return bestSum;
    }
}
