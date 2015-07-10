/*
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length==0){
            return result;
        }
        Arrays.sort(nums);
        subset(nums,new ArrayList<Integer>(),result,0);
        return result;
    }
    public void subset(int [] nums, List<Integer> current, List<List<Integer>> result,int index){  
        List<Integer> copy = new ArrayList<Integer>();
        copy.addAll(current);
        result.add(copy);
        
        for(int i=index; i<nums.length; i++){
            current.add(nums[i]);
            subset(nums,current,result,i+1);
            current.remove(current.size()-1);
        }
        
    }
}