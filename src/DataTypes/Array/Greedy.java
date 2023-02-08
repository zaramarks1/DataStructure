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
}
