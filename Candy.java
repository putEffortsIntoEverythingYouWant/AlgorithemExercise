/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/
public class Solution {
    //two sides scanning is very useful, especially when it comes to relative value with neighbors
    //this question only require higher rating get more candies than neighbors..this doesn't mean childrens on
    //the same rating will get the same amount of candy
    //purely depends on relatively difference
    public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0){
            return 0;
        }
        int [] l = new int [ratings.length];
        l[0]=1;
        for(int i=1;i<l.length; i++){
            if(ratings[i]>ratings[i-1]){
                l[i]=l[i-1]+1;
            }else{
                l[i]=1;
            }
        }
        int [] r = new int [ratings.length];
        r[r.length-1]=1;
        for(int i=r.length-2;i>=0; i--){
            if(ratings[i]>ratings[i+1]){
                r[i] = r[i+1]+1;
            }else{
                r[i]=1;
            }
        }
        int current = 0;
        for(int i=0; i<ratings.length; i++){
            current+=Math.max(r[i],l[i]);
        }
        return current;
    }
}