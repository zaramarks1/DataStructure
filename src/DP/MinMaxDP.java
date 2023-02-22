package DP;

import java.util.List;

public class MinMaxDP {

    // TODO 120. Triangle medium
    // https://leetcode.com/problems/triangle/description/
    // Runtime 2ms beats 86%
    // Memory 45mb beats 5 %
    public int minimumTotal(List<List<Integer>> triangle) {

        int[] result = new int[triangle.size()+1];

        for(int i = triangle.size()-1; i >=0; i --){
            for(int j = 0; j < triangle.get(i).size(); j ++){
                result[j] = Math.min(result[j], result[j+1]) + triangle.get(i).get(j);
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

        for (int i = 0 ; i < grid.length; i ++){

            int currCol = grid[i][0];
            if(prevCol != -1) currCol+=prevCol;

            int prevRow = -1;
            for(int j = 0; j < grid[0].length; j++){
                int currRow = grid[i][j];

                if(prevRow != -1 && prevCol!=-1)currRow+=Math.min(prevRow, grid[i-1][j]);
                else if(prevRow != -1) currRow +=prevRow;
                else if(prevCol!=-1) currRow+=grid[i-1][j];

                grid[i][j] = currRow;
                prevRow = currRow;

            }
            prevCol = currCol;
        }

        return grid[grid.length-1][grid[0].length-1];

    }
}
