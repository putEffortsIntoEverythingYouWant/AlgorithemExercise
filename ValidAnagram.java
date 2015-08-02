/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.
*/
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null && t ==null){
            return true;
        }
        if(s==null || t ==null){
            return false;
        }
        if(s.length()!=t.length()){
            return false;
        }
        int sl = s.length();
        int tl = t.length();
        Map<Character, Integer> map = new HashMap<Character,Integer>();
        for(int i=0; i<sl; i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),0);
            }
            map.put(s.charAt(i),map.get(s.charAt(i))+1);
        }
        for(int i=0;i<tl;i++){
            char current= t.charAt(i);
            if(!map.containsKey(current)){
                return false;
            }
            map.put(current,map.get(current)-1);
            if(map.get(current)==0){
                map.remove(current);
            }
        }
        if(!map.isEmpty()){
            return false;
        }
        return true;
    }
}