/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> results = new HashSet<List<Integer>>();
        if(candidates==null || candidates.length ==0){
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(candidates);
        combination(candidates,target,new ArrayList<Integer>(),results,0,0);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.addAll(results);
        return result;
    }
    public void combination(int [] candidates, int target, List<Integer> current, Set<List<Integer>> results, int sum, int index){
        if(sum == target){
            List<Integer> copy = new ArrayList<Integer>();
            copy.addAll(current);
            results.add(copy);
            return;
        }
        if(sum > target){
            return;
        }
        for(int i=index; i<candidates.length; i++){
            sum+=candidates[i];
            current.add(candidates[i]);
            combination(candidates,target,current,results,sum,i+1);
            sum-=candidates[i];
            current.remove(current.size()-1);
        }
        
    }
}