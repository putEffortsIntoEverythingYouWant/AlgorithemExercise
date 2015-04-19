/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/

/*
one character can appear in T multiple times and order doesn't matter
key point is to record what elements have been found and when it's a candidate( found all character in T), 
move start pointer to clean up unecessary/duplicate elements;
remember to update founded map when an element has been removed(start pointer has passed it)
*/
public class Solution {
    public String minWindow(String S, String T) {
        if(T==null || T.length()==0){
            return S;
        }
        if(S ==null || S.length()<T.length()){
            return "";
        }
        
        int start = 0;
        int end = 0;
        int SLength = S.length();
        int TLength = T.length();
        
        String substring = null;
        Map<Character, Integer> needed = new HashMap<Character,Integer>();
        Map<Character,Integer> founded = new HashMap<Character,Integer>();
        Map<Character,Integer> index = new HashMap<Character,Integer>();
        for(int i=0; i<TLength ; i++){
            char current = T.charAt(i);
            
            if(needed.containsKey(current)){
                needed.put(current,needed.get(current)+1);
            }else{
                needed.put(current,1);
            }
            if(index.containsKey(current)){
                index.put(current,index.get(current)+1);
            }else{
                index.put(current,1);
            }
            
            
        }
        while(start<=end && end<SLength){
            char current = S.charAt(end);
            if(index.containsKey(current)){
                
                if(founded.containsKey(current)){
                    founded.put(current,founded.get(current)+1);
                }else{
                    founded.put(current,1);
                }
                if(needed.containsKey(current)){
                    needed.put(current,needed.get(current)-1);
                    if(needed.get(current)==0){
                        needed.remove(current);
                    }
                    
                }
            }
            if(needed.isEmpty()){
                start = cleanUp(start,end,S,founded,index);
                String currentSub = S.substring(start,end+1);
                if(substring==null){
                    substring = currentSub;
                }else{
                    if(currentSub.length()<substring.length()){
                        substring = currentSub;
                    }
                }
            }
            
            end++;
        }
        
        if(substring==null){
            return "";
        }
        return substring;
        
    }
    public int cleanUp(int start, int end,String S, Map<Character,Integer> founded,Map<Character,Integer> index){
        while(start<end){
            char current = S.charAt(start);
            if(index.containsKey(current)){
                if(founded.get(current)<=index.get(current)){
                    return start;
                }
                founded.put(current, founded.get(current)-1);
            }
            start++;
        }
        return start;
    }
}