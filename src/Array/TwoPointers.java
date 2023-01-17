package Array;

public class TwoPointers {

    // TODO 977. Squares of a Sorted Array
//    Given an integer array nums sorted in non-decreasing order,
//    return an array of the squares of each number sorted in non-decreasing order.

//    Runtime
//1 ms 100%

//    Memory
//43.8 MB 86.94%

    public int[] sortedSquares(int[] nums) {

        int numsLength = nums.length;
        int[] sortedNums = new int[numsLength];

        if(nums[0] >= 0 ) for(int i = 0; i < numsLength; i++) sortedNums[i] = nums[i] *nums[i];
        else{
            int pointerLeft = 0;
            int pointerRight = numsLength-1;
            for (int i = numsLength-1; i >= 0; i--){

                if(Math.abs(nums[pointerLeft]) > Math.abs(nums[pointerRight] ) ){
                    sortedNums[i] = nums[pointerLeft]*nums[pointerLeft];
                    pointerLeft++;
                }else{
                    sortedNums[i] = nums[pointerRight]*nums[pointerRight];
                    pointerRight--;
                }
            }

        }
        return sortedNums;

    }





}
