public class Main {
    
    public static int[] snail(int[][] array) {
        int numRows = array.length;
        int numCols = array[0].length;
        int[] result = new int[numRows * numCols];
        int index = 0;
        
        int topRow = 0, bottomRow = numRows - 1, leftCol = 0, rightCol = numCols - 1;
        
        while (topRow <= bottomRow && leftCol <= rightCol) {
            for (int i = leftCol; i <= rightCol; i++) 
                result[index++] = array[topRow][i]; 
            topRow++;
            
            for (int i = topRow; i <= bottomRow; i++) 
                result[index++] = array[i][rightCol]; 
            rightCol--;
            
            if (topRow <= bottomRow) {
                for (int i = rightCol; i >= leftCol; i--) 
                    result[index++] = array[bottomRow][i]; 
                bottomRow--;
            }
            
            if (leftCol <= rightCol) {
                for (int i = bottomRow; i >= topRow; i--) 
                    result[index++] = array[i][leftCol]; 
                leftCol++;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] snailArray = snail(array);
        
        for (int num : snailArray) 
            System.out.print(num + " ");
    }
}
