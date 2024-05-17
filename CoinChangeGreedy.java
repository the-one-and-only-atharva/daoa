package Java;

import java.util.*;

public class CoinChangeGreedy {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        for (int i = 0; i < coins.length / 2; i++) {
            int temp = coins[i];
            coins[i] = coins[coins.length - 1 - i];
            coins[coins.length - 1 - i] = temp;
        }

        int count = 0;

        for (int coin : coins) {
            // if (amount == 0) break;
            if (coin <= amount) {
                count += amount / coin;
                amount %= coin;
            }
        }

        return amount == 0 ? count : -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoinChangeGreedy solution = new CoinChangeGreedy();

        System.out.print("Enter the number of coins: ");
        int numCoins = scanner.nextInt();
        int[] coins = new int[numCoins];
        System.out.println("Enter the values of coins:");
        for (int i = 0; i < numCoins; i++) {
            coins[i] = scanner.nextInt();
        }

        System.out.print("Enter the target amount: ");
        int amount = scanner.nextInt();

        scanner.close();

        int result = solution.coinChange(coins, amount);
        System.out.println("Minimum coins required: " + result);
    }
}
