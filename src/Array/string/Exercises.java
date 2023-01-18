package Array.string;

public class Exercises {

    // TODO 344. Reverse String
    // Beat 99.14% Runtime
    // Memory : 98%
    // TWO POINTER
    public void reverseString(char[] s) {

        int low = 0;
        int high = s.length-1;
        char temp = ' ';

        while( high > low){
            temp = s[low];
            s[low++] = s[high];
            s[high--] = temp;
        }

    }

    //TODO 541. Reverse String II
    //https://leetcode.com/problems/reverse-string-ii/description/
    //SOLUTION 1 - KINDA SLOW
    public String reverseStr(String s, int k) {

        int high =0; int low=0;
        int sLength = s.length();
        StringBuilder sb = new StringBuilder(s);

        for(int i =0; i<sLength; i+=2*k){
            low =i;
            //high = (i + k)<= sLength ? i+k-1 : sLength-1;
            high = Math.min(i+k-1, sLength-1);

            while(high>low){
                sb.setCharAt(low, s.charAt(high));
                sb.setCharAt(high, s.charAt(low));
                low++;high--;
            }
        }

        return sb.toString();
    }
    //SOLUTION 2
    // 1MS
    //MEMORY BEATS 80%
    public String reverseStr2(String s, int k) {

        int high =0; int low=0;
        int sLength = s.length();
        char[] charArray = s.toCharArray();

        for(int i =0; i<sLength; i+=2*k){
            low =i;
            high = Math.min(i+k-1, sLength-1);

            while(high>low){
                char temp = charArray[low];
                charArray[low] = charArray[high];
                charArray[high] = temp;
                low++;high--;
            }
        }

        return new String(charArray);

    }
}
