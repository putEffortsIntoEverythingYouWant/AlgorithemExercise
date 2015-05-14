/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
	/*
	not entirely similiar with permutate all valid parenthese combination
	using stack is not good approach for that question
	*/
public class Solution {
    public boolean isValid(String s) {
        if(s==null){
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        int length = s.length();
        for(int i=0; i<length; i++){
            char current = s.charAt(i);
            if(current=='(' || current=='{'||current=='['){
                stack.push(current);
                continue;
            }
            if(stack.isEmpty()){
                return false;//very important, will throw exception if stack is empty; return false if putting closing paren first or all open paren already popped out of stack
            }
            char topChar = stack.peek();
            if(match(current,topChar)){
                stack.pop();
            }else{
                return false;
            }
        }
        if(stack.isEmpty()){//important, make sure all open paren have corresponded close paren
            return true;
        }
        return false;
    }
    public boolean match(char current, char top){
        if(current==')'&& top=='('){
            return true;    
        }
        if(current=='}'&& top=='{'){
            return true;   
        }
        if(current==']'&& top=='['){
            return true;   
        }
        return false;
    }
}