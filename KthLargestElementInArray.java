/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/
class Solution {
    //param k : description of k
    //param numbers : array of numbers
    //return: description of return
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        // write your code here
        int left = 0;
        int right = numbers.size()-1;
        return kthElement(numbers.size()-k,left,right,numbers);
       
    }
    public int kthElement(int k, int left, int right, ArrayList<Integer> numbers){
        int start = left;
        int end = right;
         int pivot = numbers.get(right);
        while(left<right){
            while(numbers.get(left)<pivot && left<right){
                left++;
            }
            while(numbers.get(right)>=pivot && right>left){
                right--;
            }

            swap(left,right,numbers);
        }
        swap(left,end,numbers);
        if(left==k){
            return numbers.get(left);
        }
        else if(left>k){
            return kthElement(k,start,left-1,numbers);
        }else{
            return kthElement(k,left+1,end,numbers);
        }
        
    }
    public void swap(int p1, int p2, ArrayList<Integer> numbers){
        int temp = numbers.get(p1);
        numbers.set(p1,numbers.get(p2));
        numbers.set(p2,temp);
    }
};
