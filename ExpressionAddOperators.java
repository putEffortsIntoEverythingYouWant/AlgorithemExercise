/*
Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
*/

/*
key points:
1. multiply need to calculate first,but we start from left, so need to know what value is available to be multiplied with if next operator is *
2. for each call(each call deal with 1 number), if starts with 0, can only be 0
3. don't add operator in front of first number
*/
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        if(num==null){
            return result;
        }
        add(num,"",result,target,0,0,0);
        return result;
    }
    
    public void add(String num, String expression, List<String> result, int target, int index, long calResult, long multipliable){
        if(index==num.length()){
            if(calResult ==target){
                result.add(expression);
            }else{
                return;
            }
        }
        for(int i=index;i<num.length(); i++){
            if(index!= i && num.charAt(index)=='0'){
                break;
            }
            String number = num.substring(index,i+1);
            long current= Long.parseLong(number);
            if(index==0){
                add(num,expression+current,result,target,i+1,current,current);
            }else{
                add(num,expression+"+"+current,result,target,i+1,calResult+current,current);
                add(num,expression+"-"+current,result,target,i+1,calResult-current,-current);
                add(num,expression+"*"+current,result,target,i+1,calResult-multipliable+multipliable*current,multipliable*current);
            }
        }
        
    }
}