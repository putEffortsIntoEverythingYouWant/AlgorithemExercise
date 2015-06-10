/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/
public class Solution {
    //same as adding two numbers/linked lists
    public String addBinary(String a, String b) {
        if(a==null || a.length()==0){
            return b;
        }
        if(b==null || b.length()==0){
            return a;
        }
        StringBuilder builder = new StringBuilder();
        int aCur = a.length()-1;
        int bCur = b.length()-1;
        int addOn = 0;
        while(aCur>=0 && bCur>=0){
            char aChar = a.charAt(aCur);
            char bChar = b.charAt(bCur);
            if(aChar == bChar){
                builder.append(addOn);
                addOn=(aChar=='1')?1:0;
            }else{
                if(addOn==1){
                    builder.append(0);
                }else{
                    builder.append(1);
                    addOn = 0;
                }
            }
            aCur--;
            bCur--;
        }
        while(aCur>=0){
            char aChar = a.charAt(aCur);
            if((aChar =='0' && addOn == 0)||(aChar=='1' && addOn==1 )){
                builder.append(0);
            }else{
                builder.append(1);
                addOn=0;
                
            }
            aCur--;
        }
        while(bCur>=0){
            char bChar = b.charAt(bCur);
            if((bChar =='0' && addOn == 0)||(bChar=='1' && addOn==1 )){
                builder.append(0);
            }else{
                builder.append(1);
                addOn=0;
            }
            bCur--;
            
        }
        if(addOn==1){
            builder.append(addOn);
        }
        return builder.reverse().toString();
        
        
    }
}