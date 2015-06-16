/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxLength = 0;
        int sLength = s.length();
        for(int i=0; i<sLength; i++){
            char current = s.charAt(i);
            if(current=='('){
                stack.push(i);
            }else{//)
                if(stack.isEmpty() || s.charAt(stack.peek())==')'){
                    stack.push(i);
                }else{//( qualified
                    stack.pop();
                    if(stack.isEmpty()){
                        maxLength = Math.max(maxLength,i+1);//from 0 to i
                    }else{
                        maxLength = Math.max(maxLength,i-stack.peek());
                    }
                    
                }
            }
        }
        return maxLength;
    }
}