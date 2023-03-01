package DataTypes.Hash;

import java.util.HashMap;
import java.util.Map;

public class Exercises {


    public static void main(String args[]) {

        System.out.print(twoSum(new int[]{2,7,11,15}, 9));


    }

    //1 TWO SUM
        public static int[] twoSum(int[] nums, int target) {

            Map<Integer, Integer> values = new HashMap<>();


            for (int i = 0; i < nums.length; i++) {

                int complement = target - nums[i];

                if (values.containsKey(nums[i])) return new int[]{values.get(nums[i]), i};

                values.put(complement, i);
            }
            return null;

        }

        // TODO 299. Bulls and Cows MEDIUM
        // https://leetcode.com/problems/bulls-and-cows/description/
        // Runtime 3 ms Beats 94.28%
        // Memory 42.1 MB Beats 88.56%

    public String getHint(String secret, String guess) {

        Map<Character, Integer> map = new HashMap<>();

        int bulls = 0;
        int cows = 0;

        for(int i = 0 ; i < secret.length(); i ++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s == g) bulls++;
            else map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for(int i = 0; i < secret.length();i ++){

            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if(s == g)continue;

            Integer val = map.get(g);

            if(val!=null && val > 0){
                map.put(g, val - 1);
                cows++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bulls);
        sb.append("A");
        sb.append(cows);
        sb.append("B");
        return sb.toString();

    }


}
