package Java;
import java.util.*;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first string (X): ");
        String X = scanner.nextLine();

        System.out.println("Enter the second string (Y): ");
        String Y = scanner.nextLine();

        int x = X.length();
        int y = Y.length();

        String[][] L = new String[x+1][y+1];

        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = "";
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    L[i][j] = L[i-1][j-1] + X.charAt(i - 1);
                } else {
                    L[i][j] = (L[i - 1][j].length() > L[i][j - 1].length()) ? L[i - 1][j] : L[i][j - 1];
                }
            }
        }
        
        System.out.println("Longest common substring: " + L[x][y]);
        
        scanner.close();
    }
}
