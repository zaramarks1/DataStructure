package DataTypes.Stacks;

import java.util.Stack;

public class ExercisesEasy {

    // TODO 20. Valid Parentheses
    //https://leetcode.com/problems/valid-parentheses/description/

    //Runtime 2ms
    // Memory 40mb
    public boolean isValid(String s) {
        Stack<Integer> stack = new Stack<>();

        for(char c: s.toCharArray()){
            if (stack.isEmpty())stack.push(c-'0');
            else{

                if(stack.peek() == (c - '0' - 1 ) || stack.peek() == (c - '0' - 2)) stack.pop();
                else stack.push(c-'0');
            }
        }

        return stack.isEmpty();
    }

    //20. Valid Parentheses  SOLUTION 2
    // Runtime 1 ms  (beats 99%)
    //Memory 40mb
    public boolean isValid2(String s) {
        Stack<Integer> stack = new Stack<>();

        for(char c: s.toCharArray()){
            if (stack.isEmpty())stack.push(c-'0');
            else{
                if(c == '{' || c == '(' || c == '[') stack.push(c-'0');
                else {
                    int result = Math.abs(c - stack.pop() - '0' );
                    if( result > 2  || result == 0 ) return false;
                }
            }
        }
        return stack.isEmpty();
    }

    
}
