class Solution {
public int minFallingPathSum(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;

    int[][] dp = new int[row][col];

    // Base case: initialize the first row
    for (int j = 0; j < col; j++) {
        dp[0][j] = matrix[0][j];
    }

    // Start from the second row
    for (int i = 1; i < row; i++) {

        for (int j = 0; j < col; j++) {

            int up = dp[i - 1][j];

            int leftDiagonal = Integer.MAX_VALUE / 2;
            int rightDiagonal = Integer.MAX_VALUE / 2;

            if (j > 0) {
                leftDiagonal = dp[i - 1][j - 1];
            }

            if (j < col - 1) {
                rightDiagonal = dp[i - 1][j + 1];
            }

            dp[i][j] = matrix[i][j]
                    + Math.min(up,
                    Math.min(leftDiagonal, rightDiagonal));
        }
    }

    // Find the minimum in the last row
    int ans = Integer.MAX_VALUE;

    for (int j = 0; j < col; j++) {
        ans = Math.min(ans, dp[row - 1][j]);
    }

    return ans;
}

}

