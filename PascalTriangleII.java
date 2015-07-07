/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex<0){
            return new ArrayList<Integer>();
        }
        Integer [] nums = new Integer [rowIndex+1];//because Arrays.asList need Integer type
        int count = 0;
        nums[0]=1;
        while(count < rowIndex){
           
            int copy = 1;
            for(int i=1; i<=count; i++){
                int temp = nums[i];
                nums[i]=nums[i]+copy;
                copy = temp;
            }
            count++;
            nums[count]=1;
        }
        return Arrays.asList(nums);
        
    }
}