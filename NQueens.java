package Java;
import java.util.*;

public class NQueens {
    static int[] a;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the chess board (N): ");
        int n = sc.nextInt();
        a = new int[n + 1];
        Arrays.fill(a, 0);
        queen(n, 1);
        System.out.println("Total solutions: " + count);

        sc.close();
    }

    private static boolean place(int pos) {
        for (int i = 1; i < pos; i++) {
            if(a[i] == a[pos] || Math.abs(a[i] - a[pos]) == Math.abs(i - pos)) {
                return false;
            }
        }
        return true;
    }

    private static void printsol(int n) {
        count++;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i] == j) {
                    System.out.print("Q\t");
                } else {
                    System.out.print("*\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void queen(int n, int k) {
        if (k > n) {
            printsol(n);
        } else {
            for (a[k] = 1; a[k] <= n; a[k]++) {
                if (place(k)) {
                    queen(n, k + 1);
                }
            }
        }
    }
}