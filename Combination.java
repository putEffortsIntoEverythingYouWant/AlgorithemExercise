/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combination(n,1,k,0,new ArrayList<Integer>(),result);
        return result;
    }
    public void combination(int n, int start, int k, int nums,List<Integer> current, List<List<Integer>> results){
        if(nums==k){
            List<Integer> copy = new ArrayList<Integer>();
            copy.addAll(current);
            results.add(copy);
            return;
        }
        for(int i=start;i<=n; i++){
            current.add(i);
            nums++;
            combination(n,i+1,k,nums,current,results);
            current.remove(current.size()-1);
            nums--;
        }
    }
}