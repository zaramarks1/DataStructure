package DataTypes.Array;

import java.util.Arrays;

public class Greedy {

    // TODO 55. Jump Game (medium)
    // https://leetcode.com/problems/jump-game/
    // 2MS BEATS 78%
    // 42mb beats 92%

    public boolean canJump(int[] nums) {

        int maxJump = 0;
        if(nums.length == 1) return true;

        for(int i = 0; i < nums.length-1; i ++){

            // If the maximum we can go is the position we are at, we will never reach the end
            if(i > maxJump) return false;

            // if max jumps passes the end, we were able to reach it
            if(maxJump >= nums.length-1) return true;

            // calculate for each position, the maximum jump
            maxJump = Math.max(maxJump, nums[i] + i);

        }
        return maxJump >= nums.length-1;
    }

    // TODO 45. Jump Game II (MEDIUM)
    //https://leetcode.com/problems/jump-game-ii/description/
    // Runtime 1ms beats 99%
    // Memory 42mb beats 75%

    public int jump(int[] nums) {

        int count =0;
        int maxJump = 0;
        int currJump =0;

        for (int i = 0; i < nums.length-1; i ++){

            maxJump = Math.max(maxJump, i + nums[i]); //getting the maximum jump at every point

            if(i == currJump){ // if we reach the current jump
                count++; //add to the counter
                currJump = maxJump; //update the currJump to maximum jump (can be the currJump or whatever value in between)
            }
        }
        return count;
    }


    // TODO 860. Lemonade Change easy
    // https://leetcode.com/problems/lemonade-change/description/
    // Runtime 2ms beats 80 %
    // Memory 53.7mb beats 71%

    public boolean lemonadeChange(int[] bills) {

        int c5 = 0;
        int c10 = 0;

        for(int i = 0; i < bills.length; i ++){

            int bill = bills[i];
            // if we get a five bill, we add it
            if(bill == 5) c5++;
            else if (c5 == 0) return false; // if its not and we do not have any FIVES left, we return false
            else if(bill == 10) {c5--; c10++;} // if we get a TEN bill, we return the change
            else if(bill== 20) { // Same for the TWENTY
                if(c10 == 0) c5 -= 3;
                else {c5--;c10--;}
            }

            if(c5 < 0 || c10 < 0 ) return false; // we check if we got any negative numbers
        }

        return c5>=0 && c10>=0;

    }

    // TODO 455. Assign Cookies EASY
    // https://leetcode.com/problems/assign-cookies/description/
    // Runtime 7 ms beast 100 %
    // Mmeory 43mb beats 90 %
    public int findContentChildren(int[] g, int[] s) {

        int gPointer = 0;
        int sPointer = 0;

        int counter = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        while(gPointer < g.length && sPointer < s.length){

            if(s[sPointer] >= g[gPointer]){
                counter++;
                gPointer++;
            }
            sPointer++;
        }

        return counter;

    }

    // TODO 134. Gas Station MEDIUM
    // https://leetcode.com/problems/gas-station/description/
    // Runtime 2ms beats 67%
    // memory 62 beats 86%
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int startPoint = 0; //find the start point if there is
        int leftBound = 0;  //bounds between startPoint
        int rightBound = 0;

        for(int i = 0; i <gas.length; i ++){

            rightBound+=gas[i] - cost[i];

            if(rightBound < 0 ){ //if our right bound is negative it means our startPoint will not be able to advance
                leftBound += rightBound; //we put everything in the left bound
                rightBound = 0; //reset the right bound
                startPoint = i + 1; // push our startPoint to the next value
            }
        }

        if(leftBound + rightBound < 0) return -1;
        return startPoint;
    }

    // TODO 376. Wiggle Subsequence MEDIUM
    // https://leetcode.com/problems/wiggle-subsequence/description/
    // Runtime 0ms beats 100%
    // memory 439 beats 98%
    public int wiggleMaxLength(int[] nums) {

        if(nums.length == 1) return 1;

        int count = nums.length;
        int prev = 0;

        for (int i = 1; i < nums.length; i ++){

            int diff = nums[i]-nums[i-1];

            if(diff == 0 ) {count--;continue;}

            else if(prev < 0 && diff <= 0 || prev > 0 && diff >= 0 ) {
                count--;
            }
            prev = diff;
        }

        return count;

    }

    // TODO 56. Merge Intervals MEDIUM
    // https://leetcode.com/problems/merge-intervals/description/
    // Runtime 8 ms Beats 81.85%
    // Memory 47.6 MB Beats 32.4%

    public int[][] merge(int[][] intervals) {

        int counter = 1;

        int pointer = 0;

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));


        for(int i = 1; i < intervals.length; i++){

            if(intervals[pointer][1] < intervals[i][0]){
                pointer = i;
                counter++;
                continue;
            }

            intervals[pointer][1] = Math.max(intervals[pointer][1], intervals[i][1]);
            intervals[pointer][0] = Math.min(intervals[pointer][0],intervals[i][0]) ;

            intervals[i][0] = -1;
            intervals[i][1] = -1;
        }

        int[][] result = new int[counter][2];
        int pos =0;

        for(int i = 0; i < intervals.length;i++ ){
            if(intervals[i][0] != -1 ) {
                result[pos++] = intervals[i];
            }
        }
        return result;
    }

    // TODO 435. Non-overlapping Intervals MEDIUM
    //https://leetcode.com/problems/non-overlapping-intervals/description/
    // Runtime 67 ms Beats 47.87%
    // Memory 101.7 MB Beats 9.23%

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int max = intervals[0][1];
        int counter =0;


        for(int i = 1; i < intervals.length; i ++){

            if(intervals[i][0] >= max){
                max = Math.max(max, intervals[i][1]);
            }else{
                max = Math.min(max, intervals[i][1]);
                counter++;
            }
        }
        return counter;

    }

    // TODO 334. Increasing Triplet Subsequence MEDIUM
    // https://leetcode.com/problems/increasing-triplet-subsequence/description/
    // Runtime 3 ms Beats 41.60%
    // Memory 93.2 MB Beats 71.90%

    public boolean increasingTriplet(int[] nums) {

        int counter = 0;

        int min = nums[0];
        int max = nums[0];

        for(int i = 1; i < nums.length; i ++){
            int curr = nums[i];

            if(curr > max || curr > min && counter == 0){
                counter++;
                max = curr;
                if(counter == 2) return true;
                continue;
            }
            if(curr < min){
                min = curr;
            }else if (curr > min && counter == 1){
                max = curr;
            }
        }
        return counter == 2 ? true :false;
    }

}
