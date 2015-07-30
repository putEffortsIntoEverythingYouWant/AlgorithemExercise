/*
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/
public class Solution {
    //so the first one and second one may be connected
    //therefore, calculate twice, one without first node, one without last node
    public int rob(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        return   Math.max(calculate(nums,0,nums.length-2), calculate(nums,1,nums.length-1));
    }
    public int calculate(int [] nums, int start, int end){
        int [] dp = new int [end+1];
        dp[start] = nums[start];
        dp[start+1] = Math.max(dp[start],nums[start+1]);
        for(int i=start+2; i<=end; i++){
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[end];
    }
    
}