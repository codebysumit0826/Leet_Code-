class Solution {
    public int uniquePaths(int[][] grid) {
         int n = grid.length, m = grid[0].length, mod = 1_000_000_007;
        long[][][] dp = new long[n][m][2];
        dp[0][0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j > 0) {
                    if (grid[i][j - 1] == 0) dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][1];
                    else dp[i][j][0] += dp[i][j - 1][1];
                }
                if (i > 0) {
                    if (grid[i - 1][j] == 0) dp[i][j][1] += dp[i - 1][j][0] + dp[i - 1][j][1];
                    else dp[i][j][1] += dp[i - 1][j][0];
                }
                dp[i][j][0] %= mod;
                dp[i][j][1] %= mod;
            }
        }
        return (int) ((dp[n - 1][m - 1][0] + dp[n - 1][m - 1][1]) % mod);
        
    }
}