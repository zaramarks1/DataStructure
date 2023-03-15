package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class backtracking {

    // TEMPLATE
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    List<List<Integer>> res;

    // TODO 46. Permutations MEDIUM
    // https://leetcode.com/problems/permutations/description/
    // Runtime 2 ms Beats 34.75%
    // Memory 42.7 MB Beats 37.49%

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>(); // Results

        backtrack(nums, new ArrayList<>(), 0); // call the backtrack recursion

        return res; // return the results
    }

    public void backtrack(int[] nums, List<Integer> temp, int n){

        if(n == nums.length) { // if we reach the desired result
            res.add(new ArrayList<>(temp)); // add it to the list
            return; // stop
        }

        for(int i = 0; i < nums.length; i ++){ // go through every opetion possible

            if(temp.contains(nums[i])) continue; // in case we go though the same number

            temp.add(nums[i]); // add the value to our temporary list
            backtrack(nums, temp, n+1); // call the recursion for the next value

            temp.remove(temp.size()-1); // remove the last added result (go back to the good value)
        }

    }

    // TODO 17. Letter Combinations of a Phone Number MEDIUM
    // https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
    // Runtime 0 ms Beats 100%
    // Memory 41.3 MB Beats 50.29%

    public List<String> letterCombinations(String digits) {

        int dLength = digits.length();

        String[] alphabet = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        if(dLength == 0) return new ArrayList<>();

        List<String> res = new ArrayList<>();

        backtrack(digits, 0, new StringBuilder(), res, alphabet);

        return res;


    }

    public void backtrack(String digits, int index, StringBuilder temp, List<String> res, String[] alphabet){
        if(temp.length() == digits.length()){
            res.add(temp.toString());
            return;
        }

        int val = digits.charAt(index) - '0' - 2;

        for(int j = 0; j < alphabet[val].length(); j++ ){

            temp.append(alphabet[val].charAt(j));

            backtrack(digits, index+1, temp, res, alphabet);

            temp.deleteCharAt(temp.length()-1);
        }
    }
}
