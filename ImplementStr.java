/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Update (2014-11-02):
The signature of the function had been updated to return the index instead of the pointer. If you still see your function signature returns a char * or String, please click the reload button  to reset your code definition.
*/
public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle ==null){
            return -1;
        }
        if(needle.length()==0){
            return 0;
        }
        char firstChar = needle.charAt(0);
        for(int i=0; i<haystack.length(); i++){
            if(haystack.charAt(i)==firstChar){
                if(equalToWord(i,haystack,needle)){
                    return i;
                }
            }
        }
        return -1;
    }
    public boolean equalToWord(int currentIndex,String haystack,String needle){
        if(haystack.length()-currentIndex<needle.length()){
            return false;
        }
        for(int i=0; i<needle.length(); i++){
            if(needle.charAt(i)!=haystack.charAt(currentIndex)){
                return false;
            }
            currentIndex++;
        }
        return true;
    }
}