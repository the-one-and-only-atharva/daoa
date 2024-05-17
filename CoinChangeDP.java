package Java;
import java.util.*;

public class CoinChangeDP{
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoinChangeDP solution = new CoinChangeDP();

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

