package Java;
import java.util.*;

public class FifteenPuzzle {
    static final int N = 4;

    static int getInvCount(int[] arr) {
        int inv_count = 0;
        for (int i = 0; i < N * N - 1; i++) {
            for (int j = i + 1; j < N * N; j++) {
                if (arr[j] != 0 && arr[i] != 0 && arr[i] > arr[j])
                    inv_count++;
            }
        }
        return inv_count;
    }

    static int findXPosition(int[][] puzzle) {
        for (int i = N - 1; i >= 0; i--)
            for (int j = N - 1; j >= 0; j--)
                if (puzzle[i][j] == 0)
                    return N - i;
        return -1;
    }

    static boolean isSolvable(int[][] puzzle) {
        int[] arr = new int[N * N];
        int k = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                arr[k++] = puzzle[i][j];

        int invCount = getInvCount(arr);

        if (N % 2 == 1)
            return invCount % 2 == 0;
        else {
            int pos = findXPosition(puzzle);
            if (pos % 2 == 1)
                return invCount % 2 == 0;
            else
                return invCount % 2 == 1;
        }
    }

    static int calculateTotalCost(int[][] puzzle) {
        int totalCost = 0;
        int goalX, goalY;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (puzzle[i][j] != 0) {
                    goalX = (puzzle[i][j] - 1) / N;
                    goalY = (puzzle[i][j] - 1) % N;
                    totalCost += Math.abs(i - goalX) + Math.abs(j - goalY);
                }
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] puzzle = new int[N][N];
        
        System.out.println("Enter the puzzle configuration (use 0 for the blank space):");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                puzzle[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        if (isSolvable(puzzle)) {
            System.out.println("Solvable");
            int totalCost = calculateTotalCost(puzzle);
            System.out.println("Total cost: " + totalCost);
        } else {
            System.out.println("Not Solvable");
        }
    }
}
