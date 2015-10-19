/*
Count the number of prime numbers less than a non-negative number, n.
*/
public class Solution {
    public int countPrimes(int n) {
        if(n<=1){
            return 0;
        }
        boolean [] numbers = new boolean [n];
        int count=0;
        for(int i=2; i<n; i++){
            if(numbers[i]){
                continue;
            }
            count++;
            //multiply is tricky on ranges, use plus instead 
            //it's ok that numbers[i] will be marked as not prime, it's already counted
            for(int j=i; j<n; j=j+i){
                numbers[j] = true;
            }
        }
        return count;
        
    }
}