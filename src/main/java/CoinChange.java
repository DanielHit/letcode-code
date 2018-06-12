import java.util.Arrays;

/**
 * @author Daniel
 * @date 12/06/2018
 * 动态规划的思想去做
 */
public class CoinChange {
    public static void main(String[] args) {
    }

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        if (coins.length == 1) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            } else {
                return -1;
            }
        }

        if (amount % coins[coins.length - 1] == 0) {
            return amount / coins[coins.length - 1];
        }

        if (coins[coins.length - 1] > amount) {
            return coinChange(Arrays.copyOf(coins, coins.length - 1), amount);
        }

        int sub = amount % coins[coins.length - 1];
        if (coinChange(Arrays.copyOf(coins, coins.length - 1), sub) != -1) {
            return coinChange(Arrays.copyOf(coins, coins.length - 1), sub) + (amount / coins[coins.length - 1]);
        } else {
            return coinChange(Arrays.copyOf(coins, coins.length - 1), amount);
        }


    }
}
