/*
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/
public class Solution {
    // pay attention to the case of negative number and -2^32 to 2^32
    public List<String> summaryRanges(int[] nums) {
        List<String> results = new ArrayList<String>();
        if(nums==null || nums.length==0){
            return results;
        }
        int current = 0;
        int before = 0;
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<nums.length; i++){
            if(i==0){
                builder.append(nums[i]);
            }
            current = i;
            if((nums[before]<0 && nums[current]>0) || nums[current]-nums[before]>1){
                    if(!builder.toString().equals(String.valueOf(nums[before]))){
                    builder.append("->");
                    builder.append(nums[before]);
                    }
                    results.add(builder.toString());
                    builder.setLength(0);
                    builder.append(nums[current]);
                
            }
            before = i;
        }
        if(builder.length()!=0 && !builder.toString().equals(String.valueOf(nums[nums.length-1]))){//not always chatAt(0) for negative numbers
            builder.append("->");
            builder.append(nums[nums.length-1]);
    
        }
                results.add(builder.toString());
        return results;
    }
}