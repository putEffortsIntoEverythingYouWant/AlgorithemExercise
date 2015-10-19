/*
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
*/
/*
attention it is unsigned, so it will go to -2^32 to 2^32-1
comparing n's value of left shift will create problem

should use index (0-31) driven to shift it right , get current digit
*/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for(int i=0; i<32; i++){
            if(getDigit(i,n)==1){
                count++;
            }
        }
        return count;
    }
    public int getDigit(int index, int n){
        return (n>>index & 1);
    }
}