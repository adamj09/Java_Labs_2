package lab_1_1;

// Adding 2D matrices

public class Lab_1_1 {
    public static void main(String[] args) {
        // Some matrices to test sum method
        double[][][] testMatrices2D = {
            {
                {10, 10, 10},
                {10, 10, 10},
                {10, 10, 10},
            },
            {
                {10, 10, 10},
                {10, 10, 10},
                {10, 10, 10},
            },
            {
                {10, 10, 10},
                {10, 10, 10},
                {10, 10, 10},
            },
        };

        double[][][][] testMatrices3D = {
            {
                {
                    {10, 10, 10},
                    {10, 10, 10},
                    {10, 10, 10},
                },
                {
                    {10, 10, 10},
                    {10, 10, 10},
                    {10, 10, 10},
                },
                {
                    {10, 10, 10},
                    {10, 10, 10},
                    {10, 10, 10},
                },
            },
            {
                {
                    {10, 10, 10},
                    {10, 10, 10},
                    {10, 10, 10},
                },
                {
                    {10, 10, 10},
                    {10, 10, 10},
                    {10, 10, 10},
                },
                {
                    {10, 10, 10},
                    {10, 10, 10},
                    {10, 10, 10},
                },
            },
            {
                {
                    {10, 10, 10},
                    {10, 10, 10},
                    {10, 10, 10},
                },
                {
                    {10, 10, 10},
                    {10, 10, 10},
                    {10, 10, 10},
                },
                {
                    {10, 10, 10},
                    {10, 10, 10},
                    {10, 10, 10},
                },
            },
        };

        displayMatrix(matrixSum(testMatrices2D));

        System.out.println();

        displayMatrix(matrixSum(testMatrices3D));
    }

    public static double[][] matrixSum(double[][][] matrices){ // Sum array of 2D matrices
        // If the dimensions of all matrices are not all the same, return an empty matrix
        for(int i = 1; i < matrices.length; i++){
            if(matrices[i].length != matrices[i - 1].length){ // Check Rows
                return new double[0][0];
            }
            for(int j = 1; j < matrices[i].length; j++){
                if(matrices[i][j].length != matrices[i - 1][j - 1].length){ // Check Columns
                    return new double[0][0];
                }
            }
        }

        // store result here
        double[][] sumMatrix = new double[matrices[0].length][matrices[0][0].length];
        
        // Sum the matrices
        for(int i = 0; i < matrices.length; i++){
            for(int j = 0; j < matrices[i].length; j++){
                for(int k = 0; k < matrices[i][j].length; k++){
                    sumMatrix[j][k] += matrices[i][j][k];
                }
            }
        }

        return sumMatrix;
    }

    public static double[][][] matrixSum(double[][][][] matrices){ // Sum array of 3D matrices
        // If the dimensions of all matrices are not all the same, return an empty matrix
        for(int i = 1; i < matrices.length; i++){
            if(matrices[i].length != matrices[i - 1].length){ // Check Rows
                return new double[0][0][0];
            }
            for(int j = 1; j < matrices[i].length; j++){
                if(matrices[i][j].length != matrices[i - 1][j - 1].length){ // Check Columns
                    return new double[0][0][0];
                }
                for(int k = 1; k < matrices[i][j].length; k++){
                    if(matrices[i][j][k].length != matrices[i - 1][j - 1][k - 1].length){ // Check Layers/Height
                        return new double[0][0][0];
                    }
                }
            }
        }

        // store result here
        double[][][] sumMatrix = new double[matrices[0].length][matrices[0][0].length][matrices[0][0][0].length];
        
        // sum the matrices
        for(int i = 0; i < matrices.length; i++){
            for(int j = 0; j < matrices[i].length; j++){
                for(int k = 0; k < matrices[i][j].length; k++){
                    for(int l = 0; l < matrices[i][j][k].length; l++){
                        sumMatrix[j][k][l] += matrices[i][j][k][l];
                    }
                }
            }
        }

        return sumMatrix;
    }

    public static void displayMatrix(double[][] matrix){ // prints a matrix (somewhat) well formatted
        if(matrix.length == 0){
            System.out.println("Invalid matrix.");
        } else {
            System.out.println("2D Matrix");
            for(int i = 0; i < matrix.length; i++){ // Rows
                for(int j = 0; j < matrix[i].length; j++){ // Columns
                    if(j == 0){
                        System.out.print("| "); // print some open brackets
                    }

                    System.out.print(matrix[i][j] + " ");

                    if(j == matrix[i].length - 1){
                        System.out.print("| "); // print some closed brackets
                    }
                }
                System.out.println();
            }
        }
    }

    public static void displayMatrix(double[][][] matrix){
        if(matrix.length == 0){
            System.out.println("Invalid matrix.");
        } else {
            System.out.println("3D Matrix:");
            for(int i = 0; i < matrix.length; i++){ // Rows
                System.out.println("Layer " + i);
                for(int j = 0; j < matrix[i].length; j++){ // Columns
                    for(int k = 0; k < matrix[i][j].length; k++){ // Layers
                        if(k == 0){
                            System.out.print("| "); // print some open brackets
                        }

                        System.out.print(matrix[i][j][k] + " ");

                        if(k == matrix[i].length - 1){
                            System.out.print("| "); // print some closed brackets
                        }
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }
    }
}
