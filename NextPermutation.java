/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/
public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <=1){
            return;
        }
        //find A[i-1]<A[i], if doesn't exist, reverse all
        int index = nums.length-2;
        while(index>=0){
            if(nums[index]<nums[index+1]){
                break;
            }
            index--;
        }
        if(index>=0){
            int next = index;
            for(int i=nums.length-1; i>index; i--){
                if(nums[i]>nums[index]){
                    next = i;
                    break;
                }
            }
            //swap
            int temp = nums[index];
            nums[index] = nums[next];
            nums[next] = temp;
            
        }
        //reverse index+1 to length-1
        int start = index+1;
        int end = nums.length-1;
        while(start<end){
            
            int copy = nums[start];
            nums[start] = nums[end];
            nums[end] = copy;
            start++;
            end--;
        }
    }
}