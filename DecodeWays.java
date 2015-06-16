/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/
public class Solution {
    /*
    looks like combination withbacktracking but only require count - DP
    good way to solve it is to analyze an example and then come up with pattern
    */
    public int numDecodings(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int sLength = s.length();
        int [] count = new int[sLength];
        if(s.charAt(0)=='0'){
            return 0;
        }
        count[0]=1;
        if(sLength==1){
            return count[0];
        }
        if(isValid(s.substring(0,2))){
            count[1]+=1;
        }
        if(s.charAt(1)!='0'){
            count[1]+=1;
        }
        for(int i=2; i<sLength; i++){
           if(s.charAt(i)!='0'){
               count[i]+=count[i-1];
           }
           if(isValid(s.substring(i-1,i+1))){
               count[i]+=count[i-2];
           }
        }
        return count[sLength-1];
    }
    public boolean isValid(String sub){
        if(sub.charAt(0)=='0'){
            return false;
        }
        int value = Integer.parseInt(sub);
        if(value>=1 && value<=26){
            return true;
        }
        return false;
    }
}