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


}
