/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/
public class Solution {
    /*
    need to properly use the sorted array properties : if sum < required, shift smaller forward, if sum > required, shift larger forward
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length==0){
            return result;
        }
        Arrays.sort(nums);
        int indexCopy = 0;
        int i = 0;
        while(i<nums.length){
            
            int start = i+1;
            int end = nums.length-1;
            int sum = 0-nums[i];
            while(start<nums.length && start<end && end>i){
                if(nums[start]+nums[end]==sum){
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    result.add(temp);
                    //avoid duplicate
                    int startCopy = start;
                    while(start<nums.length && nums[startCopy]==nums[start]){
                        start++;
                    }
                    int endCopy = end;
                    while(end>i && nums[end]==nums[endCopy]){
                        end--;
                    }
                }else if(nums[start]+nums[end] > sum){
                    end--;
                }else {
                    start++;
                }
            }
            //avoid duplicate
            while(i<nums.length && nums[i]==nums[indexCopy]){
                i++;
            }
            indexCopy = i;
        }
        return result;
    }
}