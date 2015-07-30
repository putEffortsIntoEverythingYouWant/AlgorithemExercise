/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
public class Solution {
    public String convert(String s, int numRows) {
        if(numRows<=1 || s==null || s.length()==0){
            return s;
        }
        List<List<Character>> result = new ArrayList<List<Character>>();
        int count = 1;
        while(count<=numRows){
            result.add(new ArrayList<Character>());
            count++;
        }
        int length = s.length();
        int current = 0;
        int start = 0;
        int end = numRows-1;
        while(current<length){
            //don't forget current++
          
                for(int i=start;i<=end; i++){
                    if(current<length){
                        result.get(i).add(s.charAt(current));
                    }
                    current++;
                }
                for(int i=end-1;i>start;i--){
                    if(current<length){
                        result.get(i).add(s.charAt(current));
                    }
                    current++;
                }

        }
        StringBuilder builder = new StringBuilder();
        for(List<Character> list: result){
            for(Character charL: list){
                builder.append(charL);
            }
        }
        return builder.toString();
    }
}