package Java;
import java.util.*;

public class KMP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string: ");
        String text = sc.nextLine();

        System.out.println("Enter the pattern: ");
        String pattern = sc.nextLine();

        int i = 0;
        int j = 0;
        int ptr = -1;

        while (i < text.length() && j < pattern.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == 0) {
                    ptr = i;
                }
                i++;
                j++;
            } else {
                if (ptr != -1) {
                    i = ptr + 1;
                } else {
                    i++;
                }
                j = 0;
                ptr = -1;
            }
        }
        
        if (ptr != -1) {
            System.out.println("Pattern found at index: " + ptr);
        } else {
            System.out.println("Pattern not found");
        }

        sc.close();
    }
}
