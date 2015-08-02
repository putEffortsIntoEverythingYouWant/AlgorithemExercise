/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
*/
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums==null || nums.length==0){
            return result;
        }
        //get candidate
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==nums[candidate1]){
                count1++;
            }else if(nums[i]==nums[candidate2]){
                count2++;
            }else if(count1==0){
                 candidate1 = i;
                 count1 = 1;
            }else if(count2==0){
                 candidate2 = i;
                 count2 = 1;
            }
            else{
                    count1--;
                    count2--;
                }

        }
        //verify
        int num1 = 0;
        int num2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==nums[candidate1]){
                num1++;
            }else if(nums[i]==nums[candidate2]){
                num2++;
            }
        }
        if(num1>nums.length/3){
            result.add(nums[candidate1]);
        }
        if(num2>nums.length/3){
            result.add(nums[candidate2]);
        }
        return result;
    }
}