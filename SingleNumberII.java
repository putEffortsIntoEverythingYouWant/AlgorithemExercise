/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
public class Solution {
    public int singleNumber(int[] nums) {
        int [] countBit = new int [32];
        int result = 0;
        for(int i=0;i<32;i++){
            for(int j=0;j<nums.length;j++){
                if(((nums[j] >> i ) & 1) ==1){
                    countBit[i]=(countBit[i]+1)%3;
                }
            }
            result = result | (countBit[i]<<i);
        }
        return result;
    }
}