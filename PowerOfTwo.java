/*
Given an integer, write a function to determine if it is a power of two.
*/
public class Solution {
    public boolean isPowerOfTwo(int n) {
    //if n<0, reverse back to 0
    if(n<=0){
       return false;
    }
    //all positive number
    //0 - 31, if 1 detected, no more 1 allowed
    boolean allow = true;
    for(int i=0;i<32;i++){
        int current = getBit(n,i);
        if(current ==1 && !allow){
            return false;
        }
        if(current == 1){
            allow  = false;
        }
    }
   
    return true;
        
        
    }
    public int getBit(int n, int k){
        return (n& (1<<k))>>k;
    }
}