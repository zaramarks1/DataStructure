package SortingAlgo;

public class QuickSort {

    public int[] sortArray(int[] nums) {

        quickSort(nums, 0, nums.length-1);
        return nums;

    }

    public void quickSort(int[]nums, int start, int end){

        if(start < end){
            int pivot = partition(nums, start, end);

            // leave the pivot out for the new partition
            quickSort(nums, start, pivot-1);
            quickSort(nums, pivot+1, end);
        }
    }

    public int partition(int[] nums, int start, int end){

        int pivotV = nums[end];
        // pointer for arranging the array
        int j = start;

        for(int i = start; i < end; i ++){

            if(nums[i] < pivotV){
                int temp = nums[j];
                nums[j++] = nums[i];
                nums[i] = temp;
            }
        }

        //put the pivot at the j pointer
        int temp = nums[j];
        nums[j] = pivotV;
        nums[end] = temp;

        return j;

    }
}
