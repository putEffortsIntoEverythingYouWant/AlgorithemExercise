/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/
public class Solution {
    //user helper array to store the max of amount at each house
    public int rob(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int [] amount = new int[nums.length];
        if(nums.length==1){
            return nums[0];
        }
        nums[1]=Math.max(nums[0],nums[1]);
        for(int i=2; i<amount.length; i++){
         nums[i] = Math.max(nums[i-2]+nums[i],nums[i-1]);   
        }
        return nums[nums.length-1];
    }
}