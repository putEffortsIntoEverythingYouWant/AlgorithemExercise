/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits==null || digits.length()==0){
            return result;
        }
        //generate mapping
        int count = 2;
        List<Character> letters = new ArrayList<Character>();
        Map<Integer,List<Character>> mapping = new HashMap<Integer,List<Character>>();
        for(char current = 'a'; current<='z'; current++){
             letters.add(current);
            if(letters.size()==3 && count !=9 && count !=7){
                mapping.put(count,letters);
                letters = new ArrayList<Character>();
                count++;
                
            }else if(letters.size()==4 && (count ==9 || count ==7)){
                mapping.put(count,letters);
                letters = new ArrayList<Character>();
                count++;
            }
        }
  
        generate(digits,0,result,new StringBuilder(),mapping);
        return result;
        
    }
    public void generate(String digits, int index, List<String> result, StringBuilder builder, Map<Integer,List<Character>> mapping){
        if(index==digits.length()){
            result.add(builder.toString());
            return;
        }
        Integer current = Integer.parseInt(digits.substring(index,index+1));
        List<Character> characters = mapping.get(current);
        for(Character currentChar: characters){
            builder.append(currentChar);
            generate(digits,index+1,result,builder,mapping);
            builder.setLength(builder.length()-1);
        }
        
    }
}