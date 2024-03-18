package lab_6_1;

import java.util.ArrayList;

public class Q1 {
    public static void randomSquareMatrix(int sideLength) {
        ArrayList<Integer> columnIndices = new ArrayList<>();
        ArrayList<Integer> rowIndices = new ArrayList<>();

        int[][] matrix = new int[sideLength][sideLength];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int)Math.round(Math.random());
            }
        }
    }
}
