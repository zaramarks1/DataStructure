package DataTypes.String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    /* TODO 409. Longest Palindrome EASY
       https://leetcode.com/problems/longest-palindrome/description/
       Rutime  1ms beats 100%
       Memory 40mb beats 92%
     */
    public int longestPalindrome2(String s) {

        int[] alphabet = new int[58];
        int count = 0;
        int rest =0;

        for(char c : s.toCharArray()){

            int index = (int)c - 'A';

            if( alphabet[index] + 1 == 2){
                count+=2;
                rest--;
                alphabet[index] = 0;
            }else{
                alphabet[index]++;
                rest++;
            }
        }

        return rest > 0 ? count+1 : count;

    }

    // TODO 6. Zigzag Conversion MEDIUM
    // https://leetcode.com/problems/zigzag-conversion/description/
    // Runtime 13ms beats 40%
    // Memory 54mb beats 5%

    public String convert(String s, int numRows) {

        if(numRows == 1 || s.length() < numRows)return s;

        StringBuilder[] sbs = new StringBuilder[numRows];

        //int zigzag = numRows-2;
        int row = 0;
        int sLength = s.length();
        int increment = 1;

        for(int i = 0; i <sLength; i ++){

            if (sbs[row] == null) sbs[row] = new StringBuilder();

            sbs[row].append(s.charAt(i));

            if(row==0){increment=1;}
            if(row==numRows-1){increment=-1;}
            row+=increment;

            //row++;
            // if(row == numRows){
            //     row = numRows - 1;
            //     while(row > 1 && i < sLength-1){
            //         //i++;
            //         sbs[--row].append(String.valueOf(s.charAt(++i)));
            //         //if(row==0)row++;
            //     }
            //     row=0;
            // }
        }

        StringBuilder result = new StringBuilder(sLength);

        for(StringBuilder sb : sbs){
            result.append(sb.toString());
        }

        return result.toString();
    }

    // TODO 438. Find All Anagrams in a String (MEDIUM)
    //https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
    // Runtime 7ms beats 80%
    // Memory 43mb beats 50%

    // Sliding window

    public List<Integer> findAnagrams(String s, String p) {

        int[] alphabet = new int[26];

        List<Integer> indexAnagram = new ArrayList<>();

        for(int i = 0; i < p.length(); i ++) alphabet[p.charAt(i) - 'a']++;

        int start = 0;int end = 0;

        while (end < s.length()){

            int sIndex = s.charAt(end) - 'a';

            if(alphabet[sIndex] > 0) { // the value is in out anagram
                alphabet[sIndex]--;

                if(end-start+1 == p.length()){ // if index of end-start+1 == p.length we found an anagram
                    indexAnagram.add(start);
                    alphabet[s.charAt(start) - 'a']++;
                    start++;
                }
                end++;
            }else if (start == end) { // end is not in s and we moved up the max we can
                start++;
                end++;
                continue;
            }else{ // we move start while we still can
                alphabet[s.charAt(start) - 'a']++;
                start++;
            }
        }
        return indexAnagram;
    }

    // TODO 424. Longest Repeating Character Replacement MEDIUM
    // https://leetcode.com/problems/longest-repeating-character-replacement/description/
    // Runtime 8 ms Beats 61.37%
    // Memory 42.2 MB Beats 62.50%

    public int characterReplacement(String s, int k) {

        if(k>= s.length()-1) return s.length();

        int start = 0;

        int maxLength = 0;
        int maxLetterCount = 0;

        int[] alphabet = new int[26];

        for(int end = 0;end < s.length(); end++){

            int c = ++alphabet[s.charAt(end) - 'A'];

            maxLetterCount = Math.max(maxLetterCount, c);

            if(end - start + 1 > maxLetterCount+k){
                alphabet[s.charAt(start++) - 'A']--;
                //start++;
            }

            maxLength = Math.max(maxLength, end - start +1);
        }

        return maxLength;
    }

    // TODO 415. Add Strings EASY
    // https://leetcode.com/problems/add-strings/description/
    // Runtime 2 ms Beats 89.84%
    // Memory 42.4 MB Beats 73.79%

    public String addStrings(String num1, String num2) {

        int index1 = num1.length()-1;
        int index2 = num2.length()-1;

        int sum = 0;
        int res = 0;

        StringBuilder result = new StringBuilder();

        while(index1>=0 || index2>=0){

            sum=0;

            if(index1>=0) {
                sum+= (num1.charAt(index1)-'0');
                index1--;
            }

            if(index2>=0) {
                sum+= (num2.charAt(index2)-'0');
                index2--;
            }
            sum+=res;
            res = 0;

            if(sum > 9 ){
                res=1;
                sum -=10;
            }

            result.append(sum);
        }

        if(res==1) result.append("1");

        return result.reverse().toString();

    }
    // TODO 763. Partition Labels MEDIUM
    // https://leetcode.com/problems/partition-labels/description/
    //Runtime 4 ms Beats 77.78%
    // Memory 41.4 MB Beats 59.63%
    public List<Integer> partitionLabels(String s) {

        int[] alphabet = new int[26];

        for(int i = 0; i < s.length(); i ++){
            alphabet[s.charAt(i)-'a'] = i;
        }

        int low = 0;
        int high = 0;

        List<Integer> partitions = new ArrayList<>();

        while(high < s.length()){

            high = alphabet[s.charAt(low) - 'a'];
            int index = low;

            while(high < s.length() && high > index){
                index++;
                int highTemp = alphabet[s.charAt(index) - 'a'];

                high = Math.max(high, highTemp);
            }

            partitions.add(high - low + 1);

            high++;
            low = high;
        }
        return partitions;

    }

    // TODO 14. Longest Common Prefix EASY
    // https://leetcode.com/problems/longest-common-prefix/description/
    // Runtime 0 ms Beats 100%
    // Memory 40.7 MB Beats 47.51%

    public String longestCommonPrefix(String[] strs) {

        String prefix = strs[0];

        for(int i = 1; i < strs.length; i ++ ){
            while(prefix.length() > 0 && strs[i].indexOf(prefix)!= 0){
                prefix = prefix.substring(0, prefix.length()-1);
            }
            if(prefix.length() == 0) return "";
        }
        return prefix;
    }


}
