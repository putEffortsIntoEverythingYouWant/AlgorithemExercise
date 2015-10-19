/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.
*/
public class Solution {
    public int calculate(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        s=s.trim();//need to trim to eliminate the white space in front and at the end
        //other wise, "5  " will create trouble because it has opsTemp.length==2, which can't be distinguished from real case "5+5" (also opsTemp.length==2)
        /*
        "9" give []
        "9  " give [,  ]
        "  9" give [ ]
        "1+1" give [,+]
        if basically if anything after not empty, will be an empty element in front.
        */
        Stack<Integer> stack = new Stack<Integer>();
        String [] nums = s.split("\\+|\\-|\\*|\\/");
        String [] opsTemp = s.split("\\d+");
        
        if(opsTemp.length==0){
            return Integer.parseInt(nums[0].trim());
        }
        
        char [] ops = new char [opsTemp.length-1];
            for(int i=1; i<opsTemp.length; i++){
                ops[i-1] = opsTemp[i].trim().charAt(0);
            }
        
        stack.push(Integer.parseInt(nums[0].trim()));
        for(int i=0; i<ops.length; i++){
            if(ops[i]=='+' || ops[i]=='-'){
                int num = Integer.parseInt(nums[i+1].trim());
                if(ops[i]=='-'){
                    num = 0-num;
                }
                stack.push(num);
            }else{
                Integer prev = stack.pop();
                Integer next = Integer.parseInt(nums[i+1].trim());
                if(ops[i]=='*'){
                    stack.push(prev*next);
                    
                }else if(ops[i]=='/'){
                    stack.push(prev/next);
                }
            }
        }
        int result = 0;
        while(!stack.empty()){
            result+=stack.pop();
        }
        return result;
    }
}