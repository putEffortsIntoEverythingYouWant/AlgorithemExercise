/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
*/

/*trick is to reverse three times
1. whole array
2. first k
3. left length-k
*/
public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return;
        }
        int realK = k;
        if(nums.length<k){
            realK = k%nums.length;
        }
        reverse(nums,0,nums.length-1);
        reverse(nums,0,realK-1);
        reverse(nums,realK,nums.length-1);
    }
    
    public void reverse (int [] nums, int start, int end){
        while(start<=end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}