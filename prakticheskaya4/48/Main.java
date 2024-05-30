import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println(Arrays.toString(result()));
    }

    private static int putUser(){
        System.out.println("Введите число x ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    private static int[] arrayX(){
        int x = putUser();
        int[] result = new int[15];
        for(int i = 0; i < result.length; ++i){
            result[i] = 2 * x + 1;
            ++x;
        } 
        System.out.println(Arrays.toString(result));
        return result;
    }

    private static int[] arrayZ(){
        int x = putUser();
        int[] result = new int[15];
        for(int i = 0; i < result.length; ++i){
            result[i] = 3 * x + 1;
            ++x;
        } 
        System.out.println(Arrays.toString(result));
        return result;
    }

    private static int[] result(){
        int[] arrayY = arrayX();
        int[] arrayZ = arrayZ();

        int[] result = new int[arrayY.length];
        int j = 0, k = 0;

        for(int i = 0; i < result.length; ++i){
            if (arrayY[j] <= 13){
                if (arrayY[j] == arrayZ[k]) {
                    result[i] = arrayY[j++];
                    result[++i] = arrayY[j++];
                    ++k;
                } else if (arrayY[j+1] > arrayZ[k]){
                    result[i] = arrayZ[k++];
                    ++j;
                }
            } else {
                j++;
                k++;
                if (arrayY[j] == arrayZ[k]) {
                    result[i] = arrayY[j++];
                    result[++i] = arrayY[j++];
                    ++k;
                }
            }
        } 
        return result;
    }
}
