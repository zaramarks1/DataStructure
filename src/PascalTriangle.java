import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalTriangle {

    // Basic returning the value of a certain index using RECURSION

    public Integer getValuePascal(int row, int index){

        if(index == 0 || index == row+1 || row==0) return 1;

        return getValuePascal(row-1, index-1) + getValuePascal(row-1, index);
    }

    // TODO 118. Pascal's Triangle
    // https://leetcode.com/problems/pascals-triangle/
    // Runtime 1ms beats 70%
    // Memory 41mb beats 50%

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();

        pascal.add(new ArrayList<>());
        pascal.get(0).add(1);

        if(numRows == 1) return pascal;

        for(int i = 1; i < numRows; i ++){

            pascal.add(new ArrayList<>());
            List<Integer> pTemp = pascal.get(i);
            pTemp.add(1);

            for(int j = 1; j<i; j++){
                pTemp.add(pascal.get(i-1).get(j-1)+pascal.get(i-1).get(j));
            }
            pTemp.add(1);
        }
        return pascal;
    }

    // TODO 119. Pascal's Triangle II SOLUTION USING RECURSION and memorization
    //https://leetcode.com/problems/pascals-triangle-ii/description/
    // Runtime 1ms beats 85%
    // Memory 41mb beats 35%

    Map<Integer, Integer> cache = new HashMap<>();

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
}
