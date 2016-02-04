/*
Rotate String
Given a string and an offset, rotate string by offset. (rotate from left to right)
offset=0 => "abcdefg"
offset=1 => "gabcdef"
offset=2 => "fgabcde"
offset=3 => "efgabcd"
*/

public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        if(str==null || str.length==0){
            return;
        }
        offset = offset%str.length;
        switchElem(0,str.length-1, str);
        switchElem(0,offset-1,str);
        switchElem(offset,str.length-1,str);
    }
    
    public void switchElem(int start, int end, char[]str){
        while(start<end){
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}