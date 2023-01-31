package DataTypes.Array;

import java.util.Arrays;

public class Exercises {

    public static  int[] dailyTemperatures(int[] temperatures) {

        int high =0;
        int[] daysWarmer = new int[temperatures.length];

        for(int low =0; low < temperatures.length;low++){
            high = low;
            while( high < temperatures.length && temperatures[low]>= temperatures[high]) {
                high ++;
                System.out.println(high);
            }
            System.out.println("out");

            if(high >= temperatures.length) daysWarmer[low] =0;
            else  daysWarmer[low] = high-low;


        }

        return daysWarmer;

    }

    // TODO 26. Remove Duplicates from Sorted DataTypes.Array

    //Runtime
    //1 ms
    //Memory
    //43.6 MB

    public int removeDuplicates(int[] nums) {

        int fowardIndex = 1;

        for(int i = 0; i != nums.length-1; i ++){

            if(nums[i]< nums[i+1]){
                nums[fowardIndex++] = nums[i+1];

            }
        }
        return fowardIndex;
    }

//    TODO 561. DataTypes.Array Partition

//    Given an integer array nums of 2n integers, group these integers into
//    n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized.
//    Return the maximized sum.

    //    Runtime
    //12 ms
    //96.58%
    //    Memory
    //44.5 MB
    //75.56%
    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);
        int sum = 0;

        for(int i = 0; i < nums.length; i+=2) sum+=nums[i];

        return sum;

    }

    // TODO 747. Largest Number At Least Twice  The size of Others

    //    Runtime
    //0 ms
    //100%
    //    Memory
    //40.3 MB
    //71%
    public int dominantIndex(int[] nums) {

        int largestNumber = nums[0];
        int index = 0;
        int second = 0;

        for(int i = 1; i < nums.length; i++){

            if (nums[i] > largestNumber) {
                second = largestNumber;
                largestNumber = nums[i];
                index = i;
            }else if (nums[i] > second) second = nums[i];

        }

        return largestNumber < second*2 ?  -1 : index;

    }

    // TODO 27 REMOVE ELEMENT
    public int removeElement(int[] nums, int val) {

        int openValue = 0;

        int numsLength = nums.length;

        if(numsLength == 0) return 0;

        for(int i = 0; i < numsLength; i++){
            if(nums[i]!= val) nums[openValue++] = nums[i];
        }

        return openValue;

    }
    // TODO 35. Search Insert Position
    public int searchInsert(int[] nums, int target) {

        for(int i = nums.length-1; i >= 0;i--){
            if(nums[i] == target) return i;
            else if (nums[i]<target) return i +1;
        }

        return 0;

    }

    // TODO 66. Plus One

    //https://leetcode.com/problems/plus-one/description/
    public int[] plusOne(int[] digits) {

        int digitLength = digits.length;

        int [] sum ;

        boolean isAllNine = true;

        for(int i = 0; i < digitLength;i++){
            if(digits[i]!=9){
                isAllNine = false;
                break;
            }
        }

        if(isAllNine){
            sum = new int[digitLength+1];
            sum[0] = 1;
            return sum;
        }

        sum =  new int[digitLength];
        sum[digitLength-1] =1;

        for(int i = digitLength-1; i >= 0; i--){
            sum[i] += digits[i];
            if(sum[i]==10){
                sum[i] = 0;
                sum[i-1] +=1;
            }
        }
        return sum;
    }
    // SECOND SOLUTION = BETTER
    public int[] plusOne2(int[] digits) {

        int digitLength = digits.length;

        for(int i = digitLength-1; i >= 0; i--){
            digits[i]+=1;

            if(digits[i] <= 9) return digits;

            digits[i] = 0;
        }

        int[] newDigits = new int[digitLength+1];
        newDigits[0] = 1;

        return newDigits;
    }

    public static void main(String args[]) {

    System.out.println(dailyTemperatures(new int []{73,74,75,71,69,72,76,73}));

    }

}
