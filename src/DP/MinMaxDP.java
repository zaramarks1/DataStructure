package DP;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinMaxDP {

    // TODO 120. Triangle medium
    // https://leetcode.com/problems/triangle/description/
    // Runtime 2ms beats 86%
    // Memory 45mb beats 5 %
    public int minimumTotal(List<List<Integer>> triangle) {

        int[] result = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                result[j] = Math.min(result[j], result[j + 1]) + triangle.get(i).get(j);
            }
        }
        return result[0];

    }

    // TODO 64. Minimum Path Sum MEDIUM
    //https://leetcode.com/problems/minimum-path-sum/description/
    // Runtime 2ms beats 78%
    // Mmeory 45mb beats 61mb
    public int minPathSum(int[][] grid) {

        int prevCol = -1;

        for (int i = 0; i < grid.length; i++) {

            int currCol = grid[i][0];
            if (prevCol != -1) currCol += prevCol;

            int prevRow = -1;
            for (int j = 0; j < grid[0].length; j++) {
                int currRow = grid[i][j];

                if (prevRow != -1 && prevCol != -1) currRow += Math.min(prevRow, grid[i - 1][j]);
                else if (prevRow != -1) currRow += prevRow;
                else if (prevCol != -1) currRow += grid[i - 1][j];

                grid[i][j] = currRow;
                prevRow = currRow;

            }
            prevCol = currCol;
        }

        return grid[grid.length - 1][grid[0].length - 1];

    }

    public int minPathSum2(int[][] grid) {

        int height = grid.length;
        int width = grid[0].length;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {

                if (row == 0 && col == 0) grid[row][col] = grid[row][col];
                else if (row == 0 && col != 0) grid[row][col] = grid[row][col] + grid[row][col - 1];
                else if (col == 0 && row != 0) grid[row][col] = grid[row][col] + grid[row - 1][col];
                else grid[row][col] = grid[row][col] + Math.min(grid[row - 1][col], grid[row][col - 1]);
            }
        }
        return grid[height - 1][width - 1];
    }

    // TODO 221. Maximal Square MEDIUM
    // https://leetcode.com/problems/maximal-square/description/
    // Runtime 6ms beats 63%
    // Memory  66mb beats 11%

    public int maximalSquare(char[][] matrix) {

        int col = matrix[0].length;
        int row = matrix.length;

        if (col == 0 || row == 0) return 0;

        int maxSize = 0;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {
                int val = matrix[i][j] - '0';
                if (val == 0) continue; // if matrix is = 0 , we do not do anything

                if (j == 0 || i == 0) dp[i][j] = val; // if either j or i is 0. then we are at the "wall" of the matrix
                else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1; // or else we look at the corner right
                }
                maxSize = Math.max(maxSize, dp[i][j]);
            }
        }

        return maxSize * maxSize;
    }

    // TODO 279. Perfect Squares MEDIUM
    //https://leetcode.com/problems/perfect-squares/description/
    // Runtime 38mb beats 64%
    // Memory 44mb beats 16%

    // Time complexity: O(N * sqrt(N))
    // Space complexity: O(N)
    public int numSquares(int n) {

        if (n < 4) return n;

        int[] dp = new int[n + 1];

        dp[0] = 0; // default value

        for (int i = 1; i <= n; i++) {
            dp[i] = i;

            for (int j = 1; j * j <= i; j++) {

                int sqr = j * j;

                dp[i] = Math.min(dp[i], dp[i - sqr] + 1);
            }
        }
        return dp[n];

    }

    // TODO 931. Minimum Falling Path Sum MEDIUM
    // https://leetcode.com/problems/minimum-falling-path-sum/description/
    //Runtime 6 ms Beats 25.44%
    // Memory 43.7 MB Beats 18.34%
    public int minFallingPathSum(int[][] matrix) {

        int length = matrix.length;
        int min = Integer.MAX_VALUE;

        for(int i = length-2; i >=0; i--){

            for(int j = 0; j < length; j ++){

                if(j-1 >= 0) min= Math.min(min, matrix[i+1][j-1]);

                if(j+1 < length ) min= Math.min(min, matrix[i+1][j+1]);

                min = Math.min(min, matrix[i+1][j]);

                matrix[i][j]+=min;
                min = Integer.MAX_VALUE;
            }
        }
        for(int i : matrix[0]){
            min = Math.min(min, i);
        }
        return min;

    }

    // TODO 322. Coin Change MEDIUM
    //https://leetcode.com/problems/coin-change/description/
    //Runtime 19 ms Beats 56.99%
    // Memory 42.6 MB Beats 36.90%

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1]; // we are gonna store the count of coins we need to archieve each value 0...amount

        for(int i = 1; i < amount + 1; i ++){

            dp[i] = Integer.MAX_VALUE; //lets define a max value

            for(int c : coins){ // for each coin

                if(i - c >= 0 && dp[i-c] < Integer.MAX_VALUE) { // If i - c > 0 (so we dont get a negative index) and our count exists
                    dp[i] = Math.min(dp[i], dp[i-c] + 1); //  minimum between the value we have rn or - the coin + 1
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    // TODO 983. Minimum Cost For Tickets MEDIUM
    //https://leetcode.com/problems/minimum-cost-for-tickets/description/
    //Runtime 2 ms Beats 47.80%
    // Memory 41.9 MB Beats 25.88%

    public int mincostTickets(int[] days, int[] costs) {

        Set<Integer> set = new HashSet<>();

        int lastDay = 0;

        for(int day : days){ // adding days to a set
            set.add(day);
            lastDay = Math.max(lastDay, day); // in case the days array is not sorted
        }

        int[] dp = new int[lastDay+1];

        for(int i = 1; i < lastDay + 1 ; i++){

            if(!set.contains(i)) { // if its not in the set, we dont consider the day
                dp[i] = dp[i-1]; // just copy the cost from previous
                continue;
            }

            dp[i] = dp[i-1] + costs[0]; // default value is cost of day 1
            dp[i] = Math.min(dp[i], dp[Math.max(i-7 ,0)] + costs[1]); // cost for 7-day
            dp[i] = Math.min(dp[i], dp[Math.max(i-30 ,0)] + costs[2]); //cost for 30-day

        }
        return dp[lastDay];

    }
}
