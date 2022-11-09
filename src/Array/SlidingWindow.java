package Array;

import java.util.Arrays;

public class SlidingWindow {



    // Given an array of integers n and an integer k,
    // Find the maximum sum of any SUBARRAY of size k

    //LEET CODE NB 1

    public static int getMaxSum(int[] arr, int k){

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i =0; i < k; i++) currSum +=arr[i];

        maxSum = Math.max(maxSum, currSum);

        for(int i = k; i < arr.length;i++){

            currSum += arr[i] - arr[i-k];

            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    // Given an integer array, find a subarray having a given sum in it.
    // DYNAMIC SLIDIND WINDOW

    public static int[] findSubArraySum(int[] arr, int sum){

        int sumWindow = 0;

        int high =0;

        for(int low = 0; low < arr.length;low ++){

            while(sumWindow < sum && high< arr.length){

                sumWindow += arr[high];
                high ++;
            }
            if(sumWindow == sum) return new int[]{low, high-1};

            sumWindow -= arr[low];

        }


        return new int[]{};
    }

    //Given an integer array nums, find the subarray which has the largest sum and return its sum.
    //52

    public static int maxSubArray(int[] nums) {

        int high = 1;
        int maxSum = Integer.MIN_VALUE;
        int currWindow = 0;

        for(int low = 0; low < nums.length;low++){

            currWindow +=nums[low];
            maxSum = Math.max(maxSum, currWindow);

            while(currWindow>0 && high < nums.length){
                currWindow +=nums[high];
                high++;
                maxSum = Math.max(maxSum, currWindow);

            }

            currWindow = 0;
            low = high-1;
            high++;
            //high = low+1;

        }
        return maxSum;

    }

    public static int maxSubArray2(int[] nums) {

        int highSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i =0; i < nums.length; i++){
            currSum += nums[i];

            highSum = Math.max(highSum, currSum);

            if (currSum < 0 ) currSum = 0;
        }
        return highSum;
    }

    //Find the smallest subarray length whose sum of elements is greater than `k

    public static int findSmallestSubarrayLen(int[] arr, int k)
    {

        int currSum = 0;
        int high  = 0;
        int minLength = Integer.MAX_VALUE;

        for(int low = 0; low < arr.length; low ++){

            while (high < arr.length && currSum < k){

                currSum+=arr[high];
                high++;
            }

            if(currSum >= k){
                minLength = Math.min(minLength, high-low );
                currSum -= arr[low];
            }else if(high >= arr.length){
                return minLength;
            }

        }

        return minLength;

    }

    //88 MERGE SORTED ARRAYS
    public void merge(int[] nums1, int m, int[] nums2, int n) {


        int point1 = m-1;
        int point2 = n-1;

        int pointTotal = m + n -1;


        while( point2 >= 0 && point1>=0){

            nums1[pointTotal--]  = nums1[point1] > nums2[point2] ? nums1[point1--] : nums2[point2--];

        }

        while(point2 >= 0){
            nums1[pointTotal--]  = nums2[point2--];
        }
    }

    public static void main(String args[]){

        //System.out.print(getMaxSum(new int[]{1,2,3,4,5,6,2}, 3));

        int[] result = findSubArraySum(new int[]{2, 6, 0, 9, 7, 3, 1, 4, 1, 10}, 15);
        //for(int r: result)  System.out.println(r);

        // System.out.println(maxSubArray2(new int []{-2,1,-3,4,-1,2,1,-5,4}));

        System.out.println(findSmallestSubarrayLen(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 20));


    }

}
