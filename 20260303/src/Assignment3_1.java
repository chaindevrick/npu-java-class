public class Assignment3_1 {

    // 矩陣乘法函式
    public static int[][] multiplyMatrix(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        // 檢查是否可以相乘
        if (colsA != rowsB) {
            throw new IllegalArgumentException("矩陣無法相乘：A 的欄數必須等於 B 的列數。");
        }

        int[][] C = new int[rowsA][colsB];

        // C[i][j] = Σ A[i][k] * B[k][j]
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                C[i][j] = 0;
                for (int k = 0; k < colsA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    // 顯示矩陣
    public static void printMatrix(String name, int[][] matrix) {
        System.out.println(name + " = ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("]");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 範例矩陣 A (2x3)
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6}
        };

        // 範例矩陣 B (3x2)
        int[][] B = {
                {7, 8},
                {9, 10},
                {11, 12}
        };

        // 計算結果矩陣 C
        int[][] C = multiplyMatrix(A, B);

        // 顯示輸入與結果
        System.out.println("=== Matrix Multiplication Result ===");
        printMatrix("Matrix A", A);
        printMatrix("Matrix B", B);
        printMatrix("Matrix C (A x B)", C);
    }
}