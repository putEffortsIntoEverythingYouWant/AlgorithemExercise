/*
Count the number of k's between 0 and n. k can be 0 - 9.

Have you met this question in a real interview? Yes
Example
if n=12, k=1 in [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12], we have FIVE 1's (1, 10, 11, 12)
*/
class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int result = 0;
        for(int i=0; i<=n; i++){
            result+=count(i,k);
        }
        return result;
    }
    public int count(int num, int k){
        if(num==0 && k==0){
            return 1;
        }
        int count = 0;
        while(num!=0){
            int digit = num%10;
            if(digit==k){
                count++;
            }
            num = num/10;
        }
        return count;
    }
};

