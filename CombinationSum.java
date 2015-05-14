/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/

/*
first sort the array because non descending order is required;
because you can reuse elements, next recursion starts from current index instead of index+1, but can not go before index, it will create repetition and slowness;
take good care of the return condition;
typical question, using supportive buffer/list, add elements and remove it when further layer of recursion is done;
*/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null){
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(candidates);//sort the array
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        permutate(candidates,results,current,0,target,0);
        return results;
        
    }
    public void permutate(int [] candidates, List<List<Integer>> results, List<Integer> current, int index, int target, int sum){
        if(sum==target){
            results.add(new ArrayList<Integer>(current));//make sure create new instance, not just add reference
        }
        if(index>=candidates.length){
            return;
        }
        if(sum>target){
            return;//stop following combinations
        }
        for(int i=index; i<candidates.length; i++){
            int number = candidates[i];
            sum=sum+number;
            current.add(number);
            permutate(candidates,results,current,i,target,sum);
            sum=sum-number;
            current.remove(current.size()-1);
        }
    }
}