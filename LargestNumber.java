/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/
public class Solution {
    //sorting problem
    //new way to sort: s1+s2 vs s2+s1, because length is the same, purely depends on alphabetic order
    public String largestNumber(int[] nums) {
        if(nums==null){
            return null;
        }
        String [] numString = new String [nums.length];
        for(int i=0; i<numString.length; i++){
            numString[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numString,new StringComparator());
        StringBuilder builder = new StringBuilder();
        for(int i=numString.length-1; i>=0; i--){
            builder.append(numString[i]);
        }
        String result = builder.toString();
        //for the case of [0,0]
        //if result.charAt(0)=='0', all elements in nums must be 0, otherwise 0 will never be put in front
        if(!result.isEmpty() && result.charAt(0)=='0'){
            return "0";
        }
        return result;
    }
    
    public class StringComparator implements Comparator<String>{
        @Override
        public int compare(String s1, String s2){
            return (s1+s2).compareTo(s2+s1);
            
        }
    }
}