/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
*/
public class Solution {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        if(s==null || s.length()==0){
            return builder.toString();
        }
        List<String> words = new ArrayList<String>();
        int start = 0;
        int end = 0;
        boolean inBucket = false;
        int length = s.length();
        while(end<length){
            if(s.charAt(end)!=' ' && inBucket==false){
                //start bucket
                start = end;
                inBucket = true;
            }
            if(s.charAt(end)== ' ' && inBucket == true){
                //end bucket
                words.add(s.substring(start,end));
                inBucket = false;
            }
            end++;
          
        }
        //add last word
        if(inBucket == true){
            words.add(s.substring(start,end));
        }
        
        for(int i=words.size()-1; i>=0; i--){
            builder.append(words.get(i));
            if(i!=0){
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}