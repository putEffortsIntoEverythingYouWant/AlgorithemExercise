/*
Ugly number is a number that only have factors 3, 5 and 7.

Design an algorithm to find the Kth ugly number. The first 5 ugly numbers are 3, 5, 7, 9, 15 ...
*/
class Solution {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
        /*
        if two multiply is equal, advance both, therefore do a if check on each pointer
        instead of doing else if;
        Math.min supports long, but list.get(i) can only be int, not long
        so make arraylist contains Long object, but pointers are integer
        */
        List<Long> list = new ArrayList<Long>();
        list.add(3L);
        list.add(5L);
        list.add(7L);
        int pointer1 = 0;
        int pointer2 = 0;
        int pointer3 = 0;
        while(list.size()<k){
            long min = Math.min(
                Math.min(list.get(pointer1)*3,list.get(pointer2)*5)
                ,list.get(pointer3)*7);
            list.add(min);
            if(list.get(pointer1)*3==min){
                pointer1++;
            }
            if(list.get(pointer2)*5==min){
                pointer2++;
            }
            if(list.get(pointer3)*7==min){
                pointer3++;
            }
            
        }
        return list.get(k-1);
    }
};

