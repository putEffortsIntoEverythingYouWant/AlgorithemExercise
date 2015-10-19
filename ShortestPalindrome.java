/*
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
*/
public class Solution {
    //KMP for the start of s, 
    public String shortestPalindrome(String s) {
        if(s==null || s.length()<=1){
            return s;
        }
        String newStr = s+"#"+new StringBuilder().append(s).reverse().toString();
        int [] position = new int [newStr.length()];
        
        for(int i=1; i<position.length; i++){
            int pre = position[i-1];
            while(pre>0 && newStr.charAt(i)!=newStr.charAt(pre)){
                pre = position[pre-1];
            }
            position[i] = pre+((newStr.charAt(i)==newStr.charAt(pre))?1:0);
        }
        String toAdd = new StringBuffer().append(s.substring(position[position.length-1])).reverse().toString();
        return toAdd+s;
    }
}