package DataTypes.Array;

public class TwoPointers {

    // TODO 977. Squares of a Sorted DataTypes.Array
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

    // TODO 344. Reverse DataTypes.String
    // Beat 99.14% Runtime
    // Memory : 98%
    // TWO POINTER
    public void reverseString(char[] s) {

        int low = 0;
        int high = s.length - 1;
        char temp = ' ';

        while (high > low) {
            temp = s[low];
            s[low++] = s[high];
            s[high--] = temp;
        }


    }
    //TODO 541. Reverse DataTypes.String II
    //https://leetcode.com/problems/reverse-string-ii/description/
    //SOLUTION 1 - KINDA SLOW
    public String reverseStr(String s, int k) {

        int high =0; int low=0;
        int sLength = s.length();
        StringBuilder sb = new StringBuilder(s);

        for(int i =0; i<sLength; i+=2*k){
            low =i;
            //high = (i + k)<= sLength ? i+k-1 : sLength-1;
            high = Math.min(i+k-1, sLength-1);

            while(high>low){
                sb.setCharAt(low, s.charAt(high));
                sb.setCharAt(high, s.charAt(low));
                low++;high--;
            }
        }

        return sb.toString();

    }
    //SOLUTION 2
    // 1MS
    //MEMORY BEATS 80%
    public String reverseStr2(String s, int k) {

        int high =0; int low=0;
        int sLength = s.length();
        char[] charArray = s.toCharArray();

        for(int i =0; i<sLength; i+=2*k){
            low =i;
            high = Math.min(i+k-1, sLength-1);

            while(high>low){
                char temp = charArray[low];
                charArray[low] = charArray[high];
                charArray[high] = temp;
                low++;high--;
            }
        }

        return new String(charArray);

    }
    /* TODO 11. Container With Most Water
    https://leetcode.com/problems/container-with-most-water/description/
    Runtime 2ms beats 99%
    Memory 52 beats 94%
    */
    public int maxArea(int[] height) {

        int maxContainer = Integer.MIN_VALUE;

        int lowP = 0;
        int highP = height.length -1;

        while(lowP < highP){

            int heightPos =  Math.min(height[lowP], height[highP]);

            int currWater = heightPos * (highP - lowP);
            maxContainer = Math.max(maxContainer, currWater);

            while(lowP < height.length &&  lowP < highP && height[lowP] <= heightPos)++lowP;
            while(highP >= 0 && lowP < highP && height[highP] <= heightPos )--highP;

            // if(height[lowP] < height[highP]){
            //     lowP++;
            // }else highP--;

        }
        return maxContainer;

    }

    // TODO 540. Single Element in a Sorted Array MEDIUM
    //https://leetcode.com/problems/single-element-in-a-sorted-array/description/
    // Runtime 0ms beats 100%
    //Memory 60.6 Mb Beats 6.74%

    public int singleNonDuplicate(int[] nums) {

        if(nums.length == 1) return nums[0];

        int low = 0;
        int high = nums.length-1;
        //int middle = 0;

        if(nums[low] != nums[low+1]) return nums[low];

        if(nums[high]!= nums[high-1]) return nums[high];

        while(low <= high){

            int middle = low + (high-low) / 2;

            if(nums[middle-1] != nums[middle] && nums[middle+1] != nums[middle]) return nums[middle];

            if(middle % 2 == 0){

                if(nums[middle+1] == nums[middle]) low = middle+1;
                else high = middle -1;

            }else{
                if(nums[middle+1] != nums[middle]) low = middle+1;
                else high = middle -1;
            }
        }

        return nums[low];

    }

}
