package DataTypes.Matrix;

import java.util.HashSet;

public class Exercises {

    // IMPORTANT
    // NUMBER OF COLUMNS matrix[0].length
    // NUMBER OF ROWS matrix.length

    //ROW SIZE = NUMBER OF COLUMNS = matrix[0].length
    // COLUMN SIZE = NUMBER OF ROWS = matrix.length

    //36. Valid Sudoku

    //Runtime 15ms (beats 32%
    // Memory 43MB beats 46%
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < 9; i ++)
        {
            for(int j = 0 ; j < 9; j++){
                char num = board[i][j];
                if(num != '.'){
                    if(!set.add(num +"row"+j) || !set.add(num+"column"+i) || !set.add(num+"box"+i/3+j/3))
                        return false;
                }
            }
        }
        return true;
    }

    // 36 solution 2 using a set of integer instead of string
    // 2-3ms (beats 70-90%)
    // Memory 41mb beats 95%
    public boolean isValidSudoku2(char[][] board) {

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < 9; i ++){
            for(int j = 0 ; j < 9; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    if(!set.add((num*10) + j )
                            || !set.add((num*10) +i + 100) || !set.add((num*10) + (i/3*100) + (j/3*1000) + 1000))
                        return false;
                }
            }
        }
        return true;

    }

    //  TODO 997. Find the Town Judge EASY
    //  https://leetcode.com/problems/find-the-town-judge/
    // Runtime 3ms (beats 66%)
    // Memory 50mb (beats 76%)
    public int findJudge(int n, int[][] trust) {
        if(trust.length == n) return -1;
        if(trust.length == 0 )return n == 1? n: -1;

        int[] trustArray = new int[n];
        int countTrustee = 0;

        for(int i = 0; i < trust.length; i ++){
            int trustee = trust[i][0]-1;
            int mayor = trust[i][1]-1;

            if(trustArray[trustee] !=-1) {trustArray[trustee] =-1; countTrustee++;}
            if(trustArray[mayor]!=-1) trustArray[mayor] +=1;

            if(countTrustee == n) return -1;
            if(trustArray[mayor] == n-1) return mayor+1;
        }
        return -1;
    }

    // TODO 74. Search a 2D Matrix (MEDIUM)
    // Using binary search
    // Runtime 0ms beats 100%
    // Memory 42mb beats 56%

    public boolean searchMatrix74(int[][] matrix, int target) {

        if (matrix == null) return false;

        // size of the matrix if it were an array
        int end = matrix.length * matrix[0].length -1;
        int start = 0;
        //nb of columns
        int colQt = matrix[0].length;

        while(start <= end){
            //Divide the fake array in two
            int middle =  end + start /2;

            // now with the middle value we can convert into the index of the matrix
            int value = matrix[middle/colQt][middle%colQt];

            if(value == target) return true;

            if(value > target) end = middle-1;
            else start = middle+1;
        }
        return false;

    }

    // TODO 240. Search a 2D Matrix II (MEDIUM)
    // https://leetcode.com/problems/search-a-2d-matrix-ii/description/
    // Slow solution using divide and conquer
    // Runtime 19ms beats 7%
    // Memory 48mb beats 57%

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null) return false;
        // matrix, top, bottom, left, right, target
        return search(matrix, 0, matrix.length-1, 0, matrix[0].length-1, target);
    }


    public boolean search(int[][]matrix, int top, int bottom, int left, int right, int target){

        //If matrix has only of one value, check if equals target
        if(top == bottom && left==right) return matrix[top][left] == target;

        //if we go though the values and dont find anything
        if(  top > bottom ||  left > right) return false;

        //Find the pivot in the middle of the matrix
        int colPivot = (right+left)/2;
        int rowPivot = (bottom+top)/2;

        if(matrix[rowPivot][colPivot] > target) {
            boolean m1 = search(matrix, top, rowPivot, left, colPivot, target);
            boolean m2 = search(matrix, top, rowPivot-1, colPivot+1, right, target);
            boolean m3 = search(matrix, rowPivot+1, bottom, left, colPivot-1, target);

            return m1 || m2 || m3;

        }else if (matrix[rowPivot][colPivot] < target){
            //boolean m1 = search(matrix, top, rowPivot, left, colPivot);
            boolean m2 = search(matrix, top, rowPivot, colPivot+1, right, target);
            boolean m3 = search(matrix, rowPivot+1, bottom, left, colPivot-1, target);
            boolean m4 = search(matrix, rowPivot+1, bottom, colPivot, right, target);

            return m2 || m3 || m4;
        }
        return true;

    }

    // SOLUTION 2
    // Runtime 5ms beats 100%
    // Memory 48mb beats 66%
    // Time complexity 0(m+n)
    public boolean searchMatrix2(int[][] matrix, int target) {

        if(matrix == null) return false;

        int x = matrix.length -1;
        int y = 0;

        while(x >= 0 && y < matrix[0].length){

            int pivot = matrix[x][y];

            if(pivot==target) return true;
            if(pivot > target) x--;
            else y++;
        }
        return false;
    }

    //DFS

    // TODO 733. Flood Fill EASY
    // https://leetcode.com/problems/flood-fill/?envType=study-plan&id=level-1
    // Runtime 0ms beats 100%
    // Mmeory 49mb beats 6%

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image[sr][sc] == color) return image;
        paint(image, sr, sc, image[sr][sc], color);
        return image;

    }

    public void paint(int[][] image, int sr, int sc, int color, int newColor){

        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != color) return;

        image[sr][sc] = newColor;

        paint(image, sr -1, sc, color, newColor);
        paint(image, sr, sc-1, color, newColor);
        paint(image, sr +1, sc, color, newColor);
        paint(image, sr, sc+1, color, newColor);

    }




}
