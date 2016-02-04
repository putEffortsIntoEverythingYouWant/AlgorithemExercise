    /*
Merge two given sorted integer array A and B into a new sorted integer array.

Example
A=[1,2,3,4]

B=[2,4,5,6]

return [1,2,2,3,4,4,5,6]

Challenge
How can you optimize your algorithm if one array is very large and the other is very small?

    point is to keep the pointer at longer array going forward, do not reset
    *and consider the case that it greater than any elements in longer array
    */

    public static ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        
        // write your code here
        if(A==null || A.isEmpty()){
            return B;
        }
        if(B==null || B.isEmpty()){
            return A;
        }
        ArrayList<Integer> shorter = (A.size()>=B.size())?B:A;
        ArrayList<Integer> longer = (A.size()>=B.size())?A:B;
        
        int s = 0;
        int l = 0;
        int sSize = shorter.size();
        int lSize = longer.size();
        
        while(s<sSize){
            while(l<lSize){
                if(longer.get(l)<shorter.get(s)){
                    l++;
                }else{
                    longer.add(l,shorter.get(s));
                    lSize++;
                    break;
                }
            }
            if(l==lSize){
                longer.add(shorter.get(s));
                lSize++;
            }
            s++;
        }
        return longer;
    }