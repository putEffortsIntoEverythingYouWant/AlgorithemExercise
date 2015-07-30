/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        //find all substrings in length of 10, use hashmap
        //use bit manipulation to represent string because only 4 characters
        //this will save memory usage
        List<String> result = new ArrayList<String>();
        if(s==null || s.length()<=10){
            return result;
        }
        Map<Integer, Integer> count = new HashMap<Integer,Integer>();
        int current = 0;
        int length = s.length();
        while(current<=length-10){
            int sub = convertBit(s,current,current+9);
            if(count.containsKey(sub)){
                count.put(sub,count.get(sub)+1);
            }else{
                count.put(sub,1);
            }
            current++;
        }
        Set<Integer> keys = count.keySet();
        for(Integer key: keys){
            if(count.get(key)>1){
                result.add(convertString(key));
            }
        }
        return result;
    }
    public int convertBit(String str, int start, int end){//inclusive
        /*
        A 00  0
        C 01  1
        G 10  2
        T 11  3
        */
        int base = 0;
        for(int i=start;i<=end;i++){
            char current = str.charAt(i);
            base = base<<2;
            if(current=='A'){
                base|=0;
            }else if(current=='C'){
                base|=1;
            }else if(current =='G'){
                base|=2;
            }else if(current == 'T'){
                base|=3;
            }
        }
        return base;
    }
    public String convertString(int num){
        StringBuilder builder = new StringBuilder();
        int count = 0;
        while(count<10){
            int current = num&3;
            if(current ==0){
                builder.append('A');
            }else if(current ==1){
                 builder.append('C');
            }else if(current ==2){
                 builder.append('G');
            }else if(current ==3){
                 builder.append('T');
            }
            num = num>>2;
            count++;
        }
        builder.reverse();
        return builder.toString();
    }
}