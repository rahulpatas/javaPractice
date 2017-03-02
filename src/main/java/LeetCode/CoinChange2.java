package LeetCode;

public class CoinChange2 {

    public static int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];

        dp[0][0] = 1;
        for (int i = 1; i < amount + 1; ++i) {
            dp[i][0] = 0;
        }

        for (int j = 1; j < coins.length + 1; ++j) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < amount + 1; ++i) {
            for (int j = 1; j < coins.length + 1; ++j) {
                dp[i][j] = dp[i][j - 1];

                if (coins[j - 1] <= i) {
                    dp[i][j] += dp[i - coins[j - 1]][j];
                }
            }
        }

        return dp[amount][coins.length];
    }

    public static int change1(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args){
        int[] coins = new int[]{1, 2, 5};

        System.out.println(change1(5, coins));
    }
}
