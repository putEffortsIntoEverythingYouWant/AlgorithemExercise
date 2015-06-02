/*
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*/
/*
similar logic as edit distance...add up two dimentional array
if hard to find the pattern, just draw out the array of simple case and find out the pattern
*/
public class Solution {
    public int numDistinct(String s, String t) {
        //t is the sub
        if(s==null || s.length()==0){return 0;}
        if(t==null || t.length()==0){return 1;}
        int lengthT = t.length();
        int lengthS = s.length();
        int [][] counts = new int[lengthT+1][lengthS+1];
        for(int i=0; i<=lengthS; i++){
            counts[0][i] = 1;
        }
        for(int i=1; i<=lengthT; i++){
            counts[i][0] = 0;
        }
        for(int i=1; i<=lengthT; i++){
            for(int j=1; j<=lengthS; j++){
                if(t.charAt(i-1)==s.charAt(j-1)){//very important, counts[i][j] corresponds to i-1th char in T and j-1th char in S 
                    counts[i][j] = counts[i][j-1]+counts[i-1][j-1]; 
                }else{
                    counts[i][j] = counts[i][j-1];
                }
            }
        }
        return counts[lengthT][lengthS];
    }
}