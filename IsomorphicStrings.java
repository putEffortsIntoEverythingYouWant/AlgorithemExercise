/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
*/
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if((s==null && t==null)){
            return true;
        }
        Map<Character,Character> sTot = new HashMap<Character,Character>();
        Map<Character, Character> tTos = new HashMap<Character,Character>();
        for(int i=0; i<s.length(); i++){
            char inS= s.charAt(i);
            char inT = t.charAt(i);
            if(sTot.containsKey(inS)){
                if(inT != sTot.get(inS)){
                    return false;
                }
            }
            else{
                //not exist in sTot
                if(tTos.containsKey(inT)){
                    return false;
                }
                sTot.put(inS,inT);
                tTos.put(inT,inS);
            }
        }
        return true;
    }
}