/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || k<=0){
            return 0;
        }
        return find(nums,nums.length-k,0,nums.length-1);
   
    }
    
    public int find (int [] nums, int index, int start, int end){
        int left = start;
        int right = end;
        int pivot = nums[end];
        
        while(left<right){
            while(nums[left]<pivot && left<right){
                left++;
            }
            while(nums[right]>=pivot && right>left){
                right--;
            }
            if(left>=right){
                break;
            }
            swap(nums,left,right);
        }
        swap(nums,left,end);
        if(left==index){
            return pivot;
        }
        if(left>index){
            return find(nums,index,start,left-1);
        }
        return find(nums,index,left+1,end);
        
    }
    public void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}