package DataTypes.String;

import java.util.HashSet;
import java.util.Set;

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

    // 242. Valid Anagram EASY
    // https://leetcode.com/problems/valid-anagram/description/
    // Runtime 1ms beats 100%
    // Memory 42mb beats 96%
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        int[] alphabet = new int[26];
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        for(char sc: sChar){
            alphabet[sc-'a'] +=1;
        }
        for(char ts: tChar){
            alphabet[ts-'a'] -=1;
        }

        for(int i : alphabet) if(i!=0) return false;
        return true;
    }

    // TODO 5. Longest Palindromic Substring (MEDIUM)
    // https://leetcode.com/problems/longest-palindromic-substring/description/
    //Runtime 3ms beats 99%
    // Memory 41.9 beats 91%

    public String longestPalindrome(String s) {

        int sLength = s.length();

        if(sLength== 1) return s;

        char[] sArray = s.toCharArray();

        if(sLength == 2 && sArray[0] == sArray[1]) return s;
        else if (sLength == 2) return String.valueOf(sArray[0]);

        int low = 0; int high = 0; int maxVal = 0; int lowS = 0;

        for(int i = 0; i < sLength ; i ++){
            high=i;
            low=i;

            while(high < sLength-1 && sArray[low] == sArray[high+1]){
                high++;
                i = high;
            }

            while(low > 0 && high < sLength-1 && sArray[low-1] == sArray[high+1] ){
                low--;
                high++;
            }

            if(high-low  > maxVal) {
                lowS = low;
                maxVal = high-low;
            }
        }
        return s.substring(lowS, lowS+maxVal+1);

    }

    // TODO 205. Isomorphic Strings EASY
    //https://leetcode.com/problems/isomorphic-strings/description/
    //Runtime 3ms beats 98%
    // Memory 41mb beats 91%

    public boolean isIsomorphic(String s, String t) {

        if(s.length()!=t.length()) return false;

        int[] ascii = new int[256];

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < s.length(); i ++){

            int sChar = s.charAt(i);

            int tChar = t.charAt(i);

            if(ascii[sChar] == 0) {
                if(set.contains(tChar))return false;
                ascii[sChar] = tChar+1;
                set.add(tChar);
            }

            if(tChar!= ascii[sChar] -1)return false;
        }

        return true;
    }

    /*    TODO 392. Is Subsequence EASY
    https://leetcode.com/problems/is-subsequence/description/
    Runtime 0ms beats 100%
    Memory 40mb beats 62%*/

    public boolean isSubsequence(String s, String t) {

        int sLength = s.length();
        int tLength = t.length();

        if(sLength > tLength) return false;

        int sPointer = 0;
        int tPointer =0;

        while(sPointer < sLength && tPointer < tLength){

            if(s.charAt(sPointer)== t.charAt(tPointer)) sPointer++;
            tPointer++;
        }
        return sPointer > sLength-1;
    }
}
