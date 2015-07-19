/*
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
*/
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if((s1==null && s2==null)){
            return true;
        }
        if((s1==null && s2 !=null) || (s1!=null && s2==null)){
            return false;
        }
        if(s1.length()!=s2.length()){
            return false;
        }
        int length = s1.length();
        boolean [][][] result = new boolean [length][length][length+1];
        for(int i=0; i<length;i++){
            for(int j=0; j<length; j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    result[i][j][1] = true;
                }else{
                    result[i][j][1] = false;
                }
            }
        }
        for(int l=2; l<length+1;l++){
            for(int i=0;i<length-l+1;i++){//not i<length, controlled by current l
                for(int j=0;j<length-l+1;j++){
                    for(int k=1;k<l;k++){//cut length
                        if((result[i][j][k]&&result[i+k][j+k][l-k]) || (result[i][j+l-k][k]&&result[i+k][j][l-k])){
                            result[i][j][l]=true;
                            break;
                        }
                    }
                }
            }
        }
        return result[0][0][length];
    }
}