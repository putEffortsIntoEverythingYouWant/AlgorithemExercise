/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/
public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null || s.length()==0){
            return true;
        }
        s = s.toUpperCase();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            char char1 = s.charAt(i);
            char char2 = s.charAt(j);
            if(char1==' ' || !Character.isLetterOrDigit(char1)){
                i++;
                continue;
            }
            if(char2==' ' || !Character.isLetterOrDigit(char2)){
                j--;
                continue;
            }
            if(char1 != char2){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}