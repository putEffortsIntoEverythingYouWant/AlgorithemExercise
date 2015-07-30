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
    //just like a permutation
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        if(input==null || input.length()==0){
            return result;
        }
        String [] numbers = input.split("\\+|\\-|\\*|\\/");
        String [] ops = input.split("\\d+");
        return calculate(numbers,ops,0,numbers.length-1);
    }
    public List<Integer> calculate(String [] numbers, String [] ops, int start, int end){
            if(start==end){
                List<Integer> result = new ArrayList<Integer>();
                result.add(Integer.parseInt(numbers[start].trim()));
                return result;
            }
            List<Integer> result = new ArrayList<Integer>();
            for(int i=start+1; i<=end; i++){
                List<Integer> left = calculate(numbers,ops,start,i-1);
                List<Integer> right = calculate(numbers,ops,i,end);

                    char op = ops[i].charAt(0);
                    for(Integer leftInt: left){
                        for(Integer rightInt: right){
                            if(op=='+'){
                                result.add(leftInt+rightInt);
                        
                            }else if(op=='-'){
                                result.add(leftInt-rightInt);
                        
                            }else if(op=='*'){
                                result.add(leftInt*rightInt);
                        
                            }else if(op=='/'){
                                result.add(leftInt/rightInt);
                        
                            }
                        }
                   
                    
                }
            }
            return result;
    }
    
}