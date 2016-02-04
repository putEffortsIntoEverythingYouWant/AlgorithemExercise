/*
Easy Trailing Zeros Show result 

29% Accepted
Write an algorithm which computes the number of trailing zeros in n factorial.

Have you met this question in a real interview? Yes
Example
11! = 39916800, so the out should be 2

Challenge
O(log N) time
*/
class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here
        //is the number of 5
        long count = 0L;
        while(n!=0){
            count+=n/5;
            n=n/5;
        }
        return count;
    }
};

