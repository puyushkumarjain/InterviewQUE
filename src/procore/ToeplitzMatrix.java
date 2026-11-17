package procore;

public class ToeplitzMatrix {

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 1; i < row; i++) {

            for (int j = 1; j < col; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1])
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}
        };

        int[][] matrix2 = {
                {1, 2},
                {2, 2}
        };
        int[][] matrix3 = {
                {11, 74, 0, 93},
                {40, 11, 74, 7} // true case {40, 11, 74, 0}

        };

        System.out.println("Is matrix1 Toeplitz? " + isToeplitzMatrix(matrix1));
        System.out.println("Is matrix2 Toeplitz? " + isToeplitzMatrix(matrix2));
        System.out.println("Is matrix2 Toeplitz? " + isToeplitzMatrix(matrix3));
    }
}
