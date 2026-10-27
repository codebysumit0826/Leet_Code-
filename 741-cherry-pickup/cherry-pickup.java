import java.util.Arrays;

class Solution {

    public int cherryPickup(int[][] grid) {

        int n = grid.length;
        int[][][] dp = new int[n][n][n];

        for (int[][] plane : dp) {
            for (int[] row : plane) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        return Math.max(0, solve(0, 0, 0, grid, dp));
    }

    public int solve(int r1, int c1, int c2,
                     int[][] grid, int[][][] dp) {

        int n = grid.length;
        int r2 = r1 + c1 - c2;

        if (r1 >= n || c1 >= n || c2 >= n ||
            r2 < 0 || r2 >= n) {
            return -1000000;
        }

        if (grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return -1000000;
        }

        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        if (dp[r1][c1][c2] != Integer.MIN_VALUE) {
            return dp[r1][c1][c2];
        }

        int cherries = grid[r1][c1];

        if (r1 != r2 || c1 != c2) {
            cherries += grid[r2][c2];
        }

        int best = Math.max(
            Math.max(solve(r1 + 1, c1, c2, grid, dp),
                     solve(r1, c1 + 1, c2, grid, dp)),
            Math.max(solve(r1 + 1, c1, c2 + 1, grid, dp),
                     solve(r1, c1 + 1, c2 + 1, grid, dp))
        );

        return dp[r1][c1][c2] = cherries + best;
    }
}