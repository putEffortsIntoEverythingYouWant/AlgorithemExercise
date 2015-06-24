/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        
        boolean [] array = new boolean[s.length()];
        
        for(int i=0; i<array.length; i++){
            if(dict.contains(s.substring(0,i+1))){
                array[i]=true;
                continue;
            }
            for(int k=0; k<=i; k++){
                if(array[k]&& dict.contains(s.substring(k+1,i+1))){
                    array[i]=true;
                    continue;
                }
    
                
            }
        }
        return array[array.length-1];
        
    }
}