/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length<2){
            return 0;
        }
        int minIndex = 0;
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++){
            if(prices[i]<prices[minIndex]){
                minIndex = i;
            }
            int newProfit = prices[i]-prices[minIndex];
            if(newProfit>maxProfit){
                maxProfit = newProfit;
            }
        }
        return maxProfit;
    }
}