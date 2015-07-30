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
    //calculate * / as high priority just like it's wrapped by parenthesis
    public int calculate(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int start =0;
        int end = 0;
        int length = s.length();
        Stack<String> stack = new Stack<String>();
        boolean cal = false;
        while(end<length){
            char current = s.charAt(end);
            if(current=='+' || current=='-' || current=='*' || current=='/'){
                String num = s.substring(start,end).trim();
                stack.push(num);
                if(cal){
                    stack.push(String.valueOf(partlyCal(stack)));
                    cal = false;
                }
                stack.push(String.valueOf(current));
                if(current=='*' || current=='/'){
                    cal = true;
                }
                start = end+1;
            }
            end++;
        }
        String last = s.substring(start,end).trim();//must be a number
        //stack peek must be a symbol
        //if it's * or / then calculate it, push it in, 
        //then all left elements in stack should be + or -
            int sum = 0;
            if(stack.empty()){
                sum = Integer.parseInt(last);
            }else if(stack.peek().equals("*") || stack.peek().equals("/")){
                stack.push(last);
                stack.push(String.valueOf(partlyCal(stack)));
            }else{
                stack.push(last);
            }
    
        while(!stack.empty()){
            String num = stack.pop();
            if(!num.equals("+") && ! num.equals("-")){
                if(!stack.empty() && stack.peek().equals("-")){
                    sum-=Integer.parseInt(num);
                }else{
                    sum+=Integer.parseInt(num);
                }
            }
            
        }
        return sum;
    }
    public int partlyCal(Stack<String> stack){
        Integer num1 = Integer.parseInt(stack.pop());
        String symbol = stack.pop();
        Integer num2 = Integer.parseInt(stack.pop());
        if(symbol.equals("*")){
            return num1*num2;
        }
        if(symbol.equals("/")){
            return num2/num1;
        }
        return 0;//should never get called
    }
}