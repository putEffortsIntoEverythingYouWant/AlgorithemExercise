/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/
public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits==null || digits.length==0){
            return digits;
        }
        int addOn = 1;
        for(int i=digits.length-1; i>=0; i--){
            int num = digits[i];
            digits[i] = (num+addOn)%10;
            addOn = (num+addOn)/10;
            if(addOn==0){
                break;
            }
        }
        if(addOn!=0){
            int [] result = new int [digits.length+1];
            result[0]=addOn;
            for(int i=0; i<digits.length; i++){
                result[i+1] = digits[i];
            }
            return result;
        }
        return digits;
    }
}