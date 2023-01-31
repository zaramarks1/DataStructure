package SortingAlgo;

public class MergeSort {

    public int[] sortArray(int[] nums) {
        return divideConquer(nums, 0, nums.length-1);
    }

    public int[] divideConquer(int[] nums, int beg, int end){
        if (end == beg) return new int[]{nums[end]};
        if(beg < end){
            int lengthHalf = (end+beg)/2;
            int[] left = divideConquer(nums, beg, lengthHalf);
            int[] right = divideConquer(nums, lengthHalf+1, end);

            return merge(left, right);
        }

        return null;
    }

    public int[] merge(int[] left, int[] right){

        if(left == null || right == null) return left==null? left: right;

        int[] merged = new int[left.length + right.length];
        int pLeft = 0; int pRight = 0; int curr = 0;

        while(pLeft < left.length && pRight < right.length){
            merged[curr++] = left[pLeft] <= right[pRight] ? left[pLeft++] : right[pRight++];
        }

        while(pLeft < left.length) merged[curr++] = left[pLeft++];
        while(pRight < right.length) merged[curr++] = right[pRight++];

        return merged;
    }

}
