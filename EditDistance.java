/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/
/*
Think of extra array(or other extra space) when doing dynamic programming!!
*/
public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null && word2 == null){
            return 0;
        }
        if(word1 == null){
            return word2.length();
        }
        if(word2 == null){
            return word1.length();
        }
        int m = word1.length();
        int n = word2.length();
        int [][] steps = new int [m+1][n+1];
        for(int i=0; i<=m; i++){
            steps[i][0]=i;
        }
        for(int i=0; i<=n; i++){
            steps[0][i]=i;
        }
        for(int i=1; i<=m ; i++){
            for(int j=1; j<=n ;j++){
                int previous = steps[i-1][j-1];
                if(word1.charAt(i-1) != word2.charAt(j-1)){
                    previous++;
                }
                steps[i][j] = Math.min(previous, Math.min(steps[i-1][j]+1, steps[i][j-1]+1));
            }
        }
        return steps[m][n];
        
    }
}