/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
*/

/*
great question, when asked to return count, think of dp
basically for each number, for the number that num*num <=current number, find the qualified previous result+1, num is the gap

be careful of the initiated value

*/

public class Solution {
    public int numSquares(int n) {
     
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        int [] count = new int [n+1];
        count[0] = 0;
        for(int i=1; i<count.length; i++){
            count[i] = Integer.MAX_VALUE;
            for(int j=1; j*j<=i; j++){//do it by the gap number, not index
            	//because hard to deal with the square root 
                count[i] = Math.min(count[i],count[i-j*j]+1);
            }
        }
        return count[n];
        
    }
}