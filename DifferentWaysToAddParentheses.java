/*
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
*/
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        if(input==null){
            return new ArrayList<Integer>();
        }
        String [] nums = input.split("\\+|\\-|\\*|\\/");
        String [] ops = input.split("\\d+");
        if(ops.length<=1){
            result.add(Integer.parseInt(nums[0]));
            return result;
        }
        String [] realOps = new String [ops.length-1];
        for(int i=0; i<realOps.length; i++){
            realOps[i] = ops[i+1];
        }
        return generate(nums,realOps,0,nums.length-1);
    }
    
    public List<Integer> generate(String [] nums, String [] ops, int start, int end){
        if(start==end){
            List<Integer> result = new ArrayList<Integer>();
            result.add(Integer.parseInt(nums[start]));
            return result;
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i=start; i<=end-1; i++){
            List<Integer> left = generate(nums,ops,start,i);
            List<Integer> right = generate(nums,ops,i+1,end);
            for(Integer l: left){
                for(Integer r: right){
                    if(ops[i].equals("+")){
                        result.add(l+r);
                    }else if(ops[i].equals("-")){
                        result.add(l-r);
                    }else if(ops[i].equals("*")){
                        result.add(l*r);
                    }else if(ops[i].equals("/")){
                        result.add(l/r);
                     }
                    
                }
            }
            
        }
        return result;
    }
    
    
}