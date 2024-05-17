package Java;
import java.util.Scanner;

public class Strassen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the dimension of the square matrices: ");
        int n = scanner.nextInt();

        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        
        System.out.println("Enter elements of matrix A:");
        inputMatrix(scanner, A);
        
        System.out.println("Enter elements of matrix B:");
        inputMatrix(scanner, B);

        int[][] C = strassen(A, B);

        System.out.println("\nResult of matrix multiplication:");
        printMatrix(C);
    }

    static void inputMatrix(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    static int[][] strassen(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
        } else {
            int[][] A11 = new int[n/2][n/2];
            int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2];
            int[][] A22 = new int[n/2][n/2];

            int[][] B11 = new int[n/2][n/2];
            int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2];
            int[][] B22 = new int[n/2][n/2];

            splitMatrix(A, A11, 0, 0);
            splitMatrix(A, A12, 0, n/2);
            splitMatrix(A, A21, n/2, 0);
            splitMatrix(A, A22, n/2, n/2);

            splitMatrix(B, B11, 0, 0);
            splitMatrix(B, B12, 0, n/2);
            splitMatrix(B, B21, n/2, 0);
            splitMatrix(B, B22, n/2, n/2);

            int[][] P1 = strassen(add(A11, A22), add(B11, B22));
            int[][] P2 = strassen(add(A21, A22), B11);
            int[][] P3 = strassen(A11, subtract(B12, B22));
            int[][] P4 = strassen(A22, subtract(B21, B11));
            int[][] P5 = strassen(add(A11, A12), B22);
            int[][] P6 = strassen(subtract(A21, A11), add(B11, B12));
            int[][] P7 = strassen(subtract(A12, A22), add(B21, B22));

            int[][] C11 = add(subtract(add(P1, P4), P5), P7);
            int[][] C12 = add(P3, P5);
            int[][] C21 = add(P2, P4);
            int[][] C22 = add(subtract(add(P1, P3), P2), P6);

            joinMatrix(C11, C, 0, 0);
            joinMatrix(C12, C, 0, n/2);
            joinMatrix(C21, C, n/2, 0);
            joinMatrix(C22, C, n/2, n/2);
        }
        return C;
    }

    static int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    static int[][] subtract(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    static void splitMatrix(int[][] P, int[][] C, int iB, int jB) {
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++) {
            for (int j1 = 0, j2 = jB; j1 < C[0].length; j1++, j2++) {
                C[i1][j1] = P[i2][j2];
            }
        }
    }

    static void joinMatrix(int[][] C, int[][] P, int iB, int jB) {
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++) {
            for (int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++) {
                P[i2][j2] = C[i1][j1];
            }
        }
    }
}
