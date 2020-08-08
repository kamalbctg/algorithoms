package org.algorithom.CoinChangeMaximumNumberOfWays;

public class Solution {
    public static int findWays(int[] coins, int sum) {
        int n = coins.length;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            int c = coins[i - 1];
            for (int j = 0; j <= sum; j++) {
                if (c > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - c];
                }
            }
        }
        return dp[n][sum];
    }
}
