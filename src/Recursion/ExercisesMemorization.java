package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExercisesMemorization {

    // TODO 509. Fibonacci Number
    //https://leetcode.com/problems/fibonacci-number/description/
    // Runtime 1ms beats 47%
    // Memory 40mb beats 6%
    // In this case is better not to use recursion, this is just an example of how u can use it
    // but shouldnt given the space and time complexity.

    Map<Integer, Integer> cache = new HashMap<>();

    public int fib(int n) {

        if(n < 2) return n; // base values

        if(cache.containsKey(n)) return cache.get(n); // if key exists, we return the value

        int result = fib(n-1) + fib(n-2); // fib value of n

        cache.put(n, result); // add to the cache

        return result; // return the value

    }

    // TODO 119. Pascal's Triangle II SOLUTION USING RECURSION and memorization
    //https://leetcode.com/problems/pascals-triangle-ii/description/
    // Runtime 1ms beats 85%
    // Memory 41mb beats 35%

    //Map<Integer, Integer> cache = new HashMap<>();

    public List<Integer> getRow(int rowIndex) {
        List<Integer> values = new ArrayList<>();

        for(int i =0; i < rowIndex+1; i ++){
            values.add(getValue(rowIndex, i));
        }
        return values;
    }

    public Integer getValue(int row, int index){

        if(index == 0 || index == row || row==0) return 1;

        int placement = row + 100 + (index*1000);
        if(cache.containsKey(placement)) return cache.get(placement);
        int result = getValue(row-1, index-1) + getValue(row-1, index);
        cache.put(placement, result);

        return result;
    }

    //TODO 70. Climbing Stairs
    //https://leetcode.com/problems/climbing-stairs/description/
    //This is basically a fib sequence, but instead of getting the n value, we want n +1
    // Runtime 0MS beats 100%
    // Memory 39mb  beats 705

    public int climbStairs(int n) {
        return fibStairs(n+1);
    }

    public int fibStairs(int n ){
        if(n < 2) return n; // base values

        if(cache.containsKey(n)) return cache.get(n); // if key exists, we return the value

        int result = fibStairs(n-1) + fibStairs(n-2); // fib value of n

        cache.put(n, result); // add to the cache

        return result; // return the value
    }
}
