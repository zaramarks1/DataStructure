package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class backtracking {

    // TEMPLATE
    public List<List<Integer>> method(int[] nums) {
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

    // TODO 47. Permutations II MEDIUM
    // https://leetcode.com/problems/permutations-ii/description/
    // Runtime 2 ms Beats 79.15%
    // Memory 43.2 MB Beats 38.63%

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>>  result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);

        return result;
    }

    public void backtrack(List<List<Integer>> res,List<Integer> temp, int[] nums, boolean[] visited){

        if(temp.size() == nums.length){
            res.add(new ArrayList<Integer>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i ++){
            if(visited[i]) continue;

            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1])continue;

            temp.add(nums[i]);
            visited[i] = true;

            backtrack(res, temp, nums, visited);

            visited[i] = false;
            temp.remove(temp.size()-1);
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

    // TODO 78. Subsets MEDIUM
    // https://leetcode.com/problems/subsets/description/
    // Runtime 1 ms Beats 49.97%
    // Memory 43 MB Beats 17.43%

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        //Arrays.sort(nums);

        backtrack(res, nums, new ArrayList<>(), 0);

        return res;

    }

    public void backtrack(List<List<Integer>> res, int[] nums, List<Integer> temp, int index){

        res.add(new ArrayList<>(temp));

        for(int i = index; i < nums.length; i ++){

            if(i > index && nums[i] == nums[i-1]) continue;

            temp.add(nums[i]);

            backtrack(res, nums, temp, i+1);

            temp.remove(temp.size() -1);
        }
    }

    // TODO 1947. Maximum Compatibility Score Sum MEDIUM
    // https://leetcode.com/problems/maximum-compatibility-score-sum/description/
    // Runtime 39 ms Beats 72.73%
    // Memory 40.5 MB Beats 42.25%

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        return backtrack(students, mentors, 0, new boolean[students.length]);
    }

    public int backtrack(int[][] students, int[][] mentors, int index, boolean[] visited){

        if(index == students.length) return 0;

        int maxScore = 0;

        for(int i = 0; i < students.length; i++){

            if(visited[i]) continue;

            visited[i] = true;

            int score = calcScore(students[index], mentors[i]) + backtrack(students, mentors, index+1, visited);
            visited[i] = false;
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }

    public int calcScore(int[] student, int[] mentor){
        int score = 0;
        for(int i = 0; i < student.length; i ++){
            score+= student[i] == mentor[i] ? 1 : 0;
        }

        return score;
    }
}
