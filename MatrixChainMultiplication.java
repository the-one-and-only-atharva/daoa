package Java;
import java.util.*;

public class MatrixChainMultiplication {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of matrices: ");
        int n = scanner.nextInt();

        int[] dimensions = new int[n + 1]; // Dimensions of matrices

        System.out.println("Enter the dimensions of each matrix (separated by spaces):");
        for (int i = 0; i < n + 1; i++) {
            dimensions[i] = scanner.nextInt();
        }

        // Initialize cost and parenthesis matrices
        int[][] cost = new int[n][n];
        int[][] parenthesis = new int[n][n];

        // Initialize cost matrix with maximum values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = INF;
            }
            cost[i][i] = 0; // Diagonal elements are zero
        }

        // Dynamic programming approach to fill cost and parenthesis matrices
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int k = i; k < j; k++) {
                    int tempCost = cost[i][k] + cost[k + 1][j] + dimensions[i] * dimensions[k + 1] * dimensions[j + 1];
                    if (tempCost < cost[i][j]) {
                        cost[i][j] = tempCost;
                        parenthesis[i][j] = k;
                    }
                }
            }
        }

        // Print cost matrix
        System.out.println("Cost Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= i) {
                    System.out.print(cost[i][j] + "\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

        // Print parenthesis matrix
        System.out.println("\nOptimal Parenthesis Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= i) {
                    System.out.print(parenthesis[i][j] + "\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}

