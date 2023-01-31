package DataTypes.String;

public class Exercises {

    // TODO 387. First Unique Character in a DataTypes.String
    // First solution very slow
    // Second : Runtime 8ms (Beats 80 %)
    // Memory 50mb beats 20%

    public int firstUniqChar(String s) {

        // Map<Integer, Integer> map = new HashMap<>();

        // LinkedHashSet<Integer>  uniques = new LinkedHashSet<>();

        // for(int i = 0 ; i < s.length(); i ++){
        //     int val = s.charAt(i) - '0';

        //     if(map.containsKey(val)) uniques.remove(map.get(val));
        //     else{
        //         map.put(val, i);
        //         uniques.add(i);
        //     }
        // }

        // if(uniques.isEmpty())return -1;

        // return uniques.iterator().next();

        int[] alphabet = new int[26];
        char[] charS = s.toCharArray();

        for(char c : charS){
            int val = c - 'a';
            alphabet[val]+=1;
        }

        for(int i = 0; i < s.length();i++ ){
            if(alphabet[charS[i]-'a'] == 1){
                return i;
            }
        }

        return -1;
    }
}
