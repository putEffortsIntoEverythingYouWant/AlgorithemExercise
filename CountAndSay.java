/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/
public class Solution {
    public String countAndSay(int n) {
        if(n==0){
            return "";
        }
        int count = 1;
        String str = "1";
        while(count<n){
            str = read(str);
            count++;
        }
        return str;
    }
    public String read(String str){
        StringBuilder builder = new StringBuilder();
        int count = 0;
        char current = str.charAt(0);
        int length = str.length();
        for(int i=0; i<length; i++){
            if(str.charAt(i)==current){
                count++;
            }else{
                builder.append(count);
                builder.append(current);
                count = 1;
                current = str.charAt(i);
            }
        }
        builder.append(count);
        builder.append(current);
        return builder.toString();
    }
}