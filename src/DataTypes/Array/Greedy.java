package DataTypes.Array;

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
}
