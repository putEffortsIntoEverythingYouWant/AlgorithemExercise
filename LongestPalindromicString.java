/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/
//this is faster than DP, because DP is hardcore n*n, this approach is less than n*ave(length of palindrome) which is less than n*n
public class Solution {
    int start ;
    int max ;
    public String longestPalindrome(String s) {
        if(s==null){
            return "";
        }
        int length = s.length();
        for(int i=0; i<length; i++){
            check(s,i,i);
            check(s,i,i+1);
        }
        return s.substring(start,start+max);
    }
    
    public void check(String s, int i, int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        if(j-i-1>max){
            max = j-i-1;
            start = i+1;
        }
    }
}