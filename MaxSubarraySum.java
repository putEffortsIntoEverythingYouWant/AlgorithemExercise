/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
*/

/*
maintain the max by compare currentSum+nums[i] with nums[i]
*/
public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length==0){
            return 0;
        }
        int currentSum = nums[0];
        int maxSum = nums[0];
        for(int i=1; i<nums.length; i++){
            currentSum = Math.max(currentSum+nums[i],nums[i]);
            if(currentSum>maxSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
}