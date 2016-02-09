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
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
     /*
     two dimension to store from index i in s1, j in s2, is it able to form s3
     remember to initialize the value of 01 and 10...
     i, j is length, not index, easier to initialize, because i==0 || j==0 means not using any from s1 or s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        
        if(s1==null && s2==null && s3==null){
            return true;
        }
        if((s1==null || s2==null ) && s3!=null){
            return false;
        }
        if(s1!=null && s2!=null && s3==null){
            return false;
        }
        if(s1.length() + s2.length()!=s3.length()){
            return false;
        }
        
        boolean [][] able = new boolean [s1.length()+1][s2.length()+1];
        able[0][0] = true;
        for(int i=1; i<able.length; i++){
            if(able[i-1][0] && s1.charAt(i-1)==s3.charAt(i-1)){
                able[i][0]=true;
            }else{//no need to proceed
                break;
            }
        }
        for(int i=1; i<able[0].length; i++){
            if(able[0][i-1] && s2.charAt(i-1)==s3.charAt(i-1)){
                able[0][i]=true;
            }else{
                break;
            }
        }
        for(int i=1; i<able.length; i++){
            for(int j=1; j<able[0].length; j++){
                if((able[i-1][j] && s3.charAt(i+j-1)==s1.charAt(i-1)) 
                || (able[i][j-1] && s3.charAt(i+j-1)==s2.charAt(j-1))){
                    able[i][j]=true;
                }
            }
        }
        
        
        
        return able[s1.length()][s2.length()];
    }
}