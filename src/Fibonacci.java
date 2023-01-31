import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

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

    // SOLUTION 2 WITHOUT RECURSION
    // RUNTIME 0ms BEATS 100%
    // MEMORY 39MS BEATS 70%
    public int fib2(int n) {

        int a = 0;
        int b = 1;
        int curr = 0;
        if(n < 2) return n;
        while(n-- > 1){
            curr = a +b;
            a = b;
            b = curr;
        }
        return curr;
    }
}
