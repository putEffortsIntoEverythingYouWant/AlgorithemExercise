/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/
public class Solution {
    //each step can be jumped from step -1 or step -2
    public int climbStairs(int n) {
        //step[i] = climb 1 steps
        if(n<=2){
            return n;
        }
        int [] step = new int [n+1];
        step[0]=0;
        step[1]=1;
        step[2]=2;
        for(int i=3; i<=n; i++){
            step[i]=step[i-1]+step[i-2];
        }
        return step[n];
    }
}