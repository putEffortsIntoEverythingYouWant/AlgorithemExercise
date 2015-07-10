/*
Write a function to find the longest common prefix string amongst an array of strings.
*/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }
        int firstLength = strs[0].length();
        int index = 0;
        StringBuilder builder = new StringBuilder();
        for(int i=1; i<strs.length; i++){
            if(strs[i].length()<firstLength){
                firstLength = strs[i].length();
            }
        }
        while(index<firstLength){
            char current = strs[0].charAt(index);
            boolean satisfied = true;
            for(int i=1; i<strs.length ;i++){
                if(strs[i].charAt(index) != current){
                    satisfied = false;
                    break;
                }
            }
            if(satisfied){
                builder.append(current);
            }else{
                break;
            }
             index++;
        }
        return builder.toString();
    }
}