/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
*/
public class Solution {
    /*
    detail!!!!!
    1. last substring in s
    2. stack empty handling
    3. "-"
    4.remaining elements in stack
    */
    public int calculate(String s) {
        Stack<String> stack = new Stack<String>();
        
        int start = 0;
        int end = 0;
        int length = s.length();
        int sum = 0;
        while(end <length){
            char current = s.charAt(end);
            if(current==')' || current=='('|| current =='+' || current=='-'){
                //add front 
                String before = s.substring(start,end).trim();
                if(before.length()!=0){
                    stack.push(before);
                }
                //add current
                if(current==')'){
                    //start pop
                    stack.push(String.valueOf(calculate(stack)));
                }
                else{
                    stack.push(String.valueOf(current));
                }
                //move to next
                start = end+1;
            }
            end++;
        }
        //last element
        String before = s.substring(start,end).trim();
        if(before.length()!=0){
            stack.push(before);
        }
        //if stack is not empty, add the remaining
        while(!stack.empty()){
            String current = stack.pop();
            if(!current.equals("+") && !current.equals("-")){
                if(!stack.empty() && stack.peek().equals("-")){
                    sum-=Integer.parseInt(current);
                }else{
                    sum+=Integer.parseInt(current);
                }
            }
            
        }
        return sum;
    }
    //assume must be a "(" exists in the stack, this only calculate one set of parenthes
    public int calculate(Stack<String> stack){
        int sum = 0;
        while(!stack.peek().equals("(")){
            String current = stack.pop();
            if(!current.equals("+") && !current.equals("-")){
                if(!stack.empty() && stack.peek().equals("-")){
                    sum-=Integer.parseInt(current);
                }else{
                    sum+=Integer.parseInt(current);
                }
            }
        }
        stack.pop();//pop out the (
        return sum;
    }
}