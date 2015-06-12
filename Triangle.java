/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

public class Solution {
      /*
    DP with helper array, row I data can simply be overriden by rowI+1, 
    so only need 1 dimentional array, just override the value
    two ways to solve the problem:
    1. bottom up -  nums[j]=Math.min(nums[j],nums[j+1])+triangle.get(i).get(j);    with j from 0 to size, nums[j] won't affect nums[j+1] calculation, j and j+1 must exist in nums, so no need to check range
        
    2.top down - nums[j]=Math.min(nums[j-1],nums[j])+triangle.get(i).get(j)
        with j from size to 0, because nums[j] will affect nums[j+1] calculation, so j need to be from size to 0, need to be careful of j-1 and j range because j-1 might be -1, j may be over i-1 list size
    */

    //bottom up
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null){return 0;}
        List<Integer> bottom = triangle.get(triangle.size()-1);
        int size = bottom.size();
        int [] nums = new int [size];
        for(int i=0; i<size; i++){
            nums[i]=bottom.get(i);
        }
        int rowNum = triangle.size();
        for(int i=rowNum-2; i>=0; i--){
            List<Integer> currentList = triangle.get(i);
            int currentSize = currentList.size();
            for(int j=0; j<currentSize; j++){
                nums[j]=Math.min(nums[j],nums[j+1])+triangle.get(i).get(j);
            }
        }
        return nums[0];
        
    }

    //top down
        public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null){return 0;}
        List<Integer> bottom = triangle.get(triangle.size()-1);
        int size = bottom.size();
        int [] nums = new int [size];
        nums[0]=triangle.get(0).get(0);
        int rowNum = triangle.size();
        for(int i=1; i<rowNum; i++){
            List<Integer> current = triangle.get(i);
            int currentSize = current.size();
            int beforeSize = triangle.get(i-1).size();
            for(int j=currentSize-1; j>=0; j--){
                if(j-1<0){
                    nums[j]=nums[j]+current.get(j);
                    continue;
                }
                if(j>=beforeSize){
                    nums[j]=nums[j-1]+current.get(j);
                    continue;
                }
                nums[j]=Math.min(nums[j-1],nums[j])+current.get(j);
                
                
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<min){
                min=nums[i];
            }
        }
        return min;
        
    }
}