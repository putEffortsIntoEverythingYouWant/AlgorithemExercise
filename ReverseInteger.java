/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/
public class Solution {
    public int reverse(int x) {
        if(x==0){
            return 0;
        }
        String num = String.valueOf(x);
        String reverse = null;
        boolean negative = false;
        if(num.charAt(0)=='-'){
            reverse = reverseStr(num.substring(1,num.length()));
            negative = true;
        }else{
            reverse = reverseStr(num);
        }
        
        if(reverse.length()==10){//possible overflow
            if(overflow(reverse,negative)){
                return 0;
            }
        }
        //remove 0
        int realNum = 0;
        while(reverse.charAt(realNum)=='0'){
            realNum++;
        }
        String finalNum = reverse.substring(realNum,reverse.length());
        return (negative)?0-Integer.parseInt(finalNum):Integer.parseInt(finalNum);
        
    }
    public boolean overflow(String num, boolean negative){
        String max = null;
        if(negative){
            max = "2147483648";
        }else{
            max = "2147483647";
        }
        for(int i=0; i<max.length(); i++){//only first diff matters
            if(num.charAt(i)<max.charAt(i)){
                return false;
            }
            if(num.charAt(i)>max.charAt(i)){
                return true;
            }
        }
        return false;
    }
    
    public String reverseStr(String str){
        char [] array = str.toCharArray();
        int start = 0;
        int end = array.length-1;
        while(start<=end){
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        return new String(array);
    }
}