/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.

Hint:

The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
*/


/*
good example to combine lists on the same list base, just numbers of indexes, but get value from the same list, this will make sure all possibilities are included
*/
public class Solution {
    public int nthUglyNumber(int n) {
        if(n<=0){
            return -1;
        }
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        int a = 0;
        int b = 0;
        int c =0;
        int count = 1;
        while(count<n){
            int number = Math.min(result.get(a)*2, Math.min(result.get(b)*3, result.get(c)*5));
            count++;
            result.add(number);
            if(result.get(a)*2==number){
                a++;
            }
            if(result.get(b)*3==number){
                b++;
            }
            if(result.get(c)*5==number){
                c++;
            }
            
        }
        return result.get(n-1);
    }
}