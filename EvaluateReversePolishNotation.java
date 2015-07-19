/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<tokens.length; i++){
            String current = tokens[i];
            if(current.equals("+") || current.equals("-") ||
            current.equals("*") || current.equals("/")){
                //calculate
                int num1 = stack.pop();
                int num2 = stack.pop();
                int result = calculate(current,num1,num2);
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(current));
            }
        }
        return stack.pop();
    }
    public int calculate(String symbol, int num1, int num2){
        if(symbol.equals("+")){
            return num1+num2;
        }
        if(symbol.equals("-")){
            return num2 - num1;
        }
        if(symbol.equals("*")){
            return num1 * num2;
        }
        if(symbol.equals("/")){
            return num2/num1;
        }
        return 0;
    }
}