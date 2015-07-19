/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/
public class Solution {
//O(n*n)
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0){
            return "";
        }
        int length = s.length();
        int max =0;
        int start = 0;
        int end = 0;
        int [][] p = new int [length][length];
        for(int j=0; j<length; j++){
            for(int i=0; i<=j; i++){
                if(i==j){
                    p[i][j]=1;
                }else if(j==i+1){
                    p[i][j] = (s.charAt(i)==s.charAt(j))?2:0;
                }else{
                    if(p[i+1][j-1]!=0 && s.charAt(i)==s.charAt(j)){
                        p[i][j]=p[i+1][j-1]+2;
                    }else{
                        p[i][j]=0;
                    }
                }
                if(p[i][j]>max){
                    max = p[i][j];
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start,end+1);
    }
}