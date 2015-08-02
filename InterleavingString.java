/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        //match[i][j] means if it matched with substr1 of length i from s1and subtr2 of length j from s2
        if(s1==null && s2==null){
            if(s3==null){
                return true;
            }else{
                return false;
            }
        }
        if(s1==null || s2==null){
            if((s1==null && s2.equals(s3))||(s2==null && s1.equals(s3))){
                return true;
            }else{
                return false;
            }
        }
        int length1 = s1.length();
        int length2 = s2.length();
        if(length1+length2 != s3.length()){
            return false;
        }
        boolean [][] match = new boolean [length1+1][length2+1];
        for(int row = 0; row<length1+1; row++){
            match[row][0] = s3.substring(0,row).equals(s1.substring(0,row));
        }
        for(int col = 0; col<length2+1; col++){
            match[0][col] = s3.substring(0,col).equals(s2.substring(0,col));
        }
        for(int i = 1;i<length1+1; i++){
            for(int j=1; j<length2+1; j++){
                match[i][j] = (match[i][j-1]&& s3.charAt(i+j-1)==s2.charAt(j-1)) || (match[i-1][j] && s3.charAt(i+j-1)==s1.charAt(i-1));
            }
        }
        return match[length1][length2];
    }
}