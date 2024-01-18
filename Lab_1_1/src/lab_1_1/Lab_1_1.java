package lab_1_1;

// Adding 2D matrices

public class Lab_1_1 {
    public static void main(String[] args) {
        double[][][] testMatrices = {
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

        double[][] result = sumMatrices(testMatrices).clone();

        if(result.length == 0){ // check if result is valid
            System.out.println("Matrices are not of the same dimensions or are staggered!");
        }
        else {
            System.out.println("Sum of matrices: ");
            for(int i = 0; i < result.length; i++){
                for(int j = 0; j < result[i].length; j++){
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static double[][] sumMatrices(double[][][] matrices){ // Add 2D matrices
        // If the dimensions of all matrices are not all the same, return an empty matrix
        for(int i = 1; i < matrices.length; i++){
            if(matrices[i].length != matrices[i - 1].length){ // Rows
                return new double[0][0];
            }
            for(int j = 1; j < matrices[i].length; j++){ // Columns
                if(matrices[i][j].length != matrices[i - 1][j - 1].length){
                    return new double[0][0];
                }
            }
        }

        double[][] sumMatrix = new double[matrices[0].length][matrices[0][0].length]; // store result here
        
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
}
