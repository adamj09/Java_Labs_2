package lab_6_1;

import java.util.ArrayList;

public class Q1 {
    public static ArrayList<Integer> largestColumns(int[][] matrix) {
        ArrayList<Integer> columnIndices = new ArrayList<>();

        int previousColumnSum = 0;
        for(int i = 0; i < matrix[0].length; i++){ // Do this for every column
            int columnSum = 0;
            for(int j = 0; j < matrix.length; j++){ // Get sum for current column
                columnSum += matrix[j][i];
            }
            
            if(columnSum > previousColumnSum) { // Remove all indices and add new max to list
                columnIndices.clear();
                columnIndices.add(i);
                previousColumnSum = columnSum;
            }
            else if(columnSum == previousColumnSum) { // Add index to list if there are 2 or more maxes
                columnIndices.add(i);
            }
        }

        return columnIndices;
    }

    public static ArrayList<Integer> largestRows(int[][] matrix) {
        ArrayList<Integer> rowIndices = new ArrayList<>();

        int previousRowSum = 0;
        for(int i = 0; i < matrix.length; i++){ // Do this for every row
            int rowSum = 0;
            for(int j = 0; j < matrix[i].length; j++){ // Get sum for current row
                rowSum += matrix[i][j];
            }

            if(rowSum > previousRowSum) { // Remove all indices and add new max to list
                rowIndices.clear();
                rowIndices.add(i);
                previousRowSum = rowSum;
            }
            else if(rowSum == previousRowSum) { // Add index to list if there are 2 or more maxes
                rowIndices.add(i);
            }
        }

        return rowIndices;
    }

    public static int[][] randomSquareMatrix(int sideLength) {
        int[][] matrix = new int[sideLength][sideLength];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int)Math.round(Math.random());
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
