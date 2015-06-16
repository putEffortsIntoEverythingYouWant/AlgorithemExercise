/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        addUp(1,k,1,n,0,new ArrayList<Integer>(),results);
        return results;
    }
    public void addUp(int start,int k, int index, int n, int sum, List<Integer> nums, List<List<Integer>> results){
        if(sum==n && index-k==1){
            List<Integer> copy = new ArrayList<Integer>();
            copy.addAll(nums);
            results.add(copy);
            return;
        }
        if(start>=n || index>k){
            return;
        }
        for(int i= start; i<=9;i++){//1-9
            sum+=i;
            nums.add(i);
            addUp(i+1,k,index+1,n,sum,nums,results);
            sum-=i;
            nums.remove(nums.size()-1);
        }
    }
}