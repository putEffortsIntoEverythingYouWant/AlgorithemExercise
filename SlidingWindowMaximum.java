/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
*/
public class Solution {
    //use double end queque (ArrayDeque or LinkedList) to store the index
    //pollfirst the element that out of current window of K
    //polllast the element that are smaller than current element that are being pushed into queue
    //therefore, peekFirst is always the max for current window
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> deQ = new LinkedList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        if(nums==null){return listToArray(result);}
        for(int i=0; i<nums.length; i++){
            while(deQ.peekFirst()!=null && deQ.peekFirst()<i-k+1){
                deQ.pollFirst();
            }
            while(deQ.peekLast()!=null && nums[deQ.peekLast()]<nums[i]){
                deQ.pollLast();
            }
            deQ.addLast(i);
            if(i>=k-1){
                result.add(nums[deQ.peekFirst()]);
            }
        }
        return listToArray(result);
    }
    public int [] listToArray(List<Integer> list){
        int [] result = new int [list.size()];
        int count = 0;
        for(Integer inte:list){
            result[count] = inte;
            count++;
        }
        return result;
    }
}