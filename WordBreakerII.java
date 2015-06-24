/*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/
public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if(s==null){return null;}
        List<String> result = new ArrayList<String>();
        boolean [] possible = new boolean [s.length()];
        for(int i=0; i<possible.length; i++){
            possible[i]=true;
        }
        searchWords(s,0,result,new StringBuilder(),wordDict,possible);
        return result;
    }
    public void searchWords(String s, int start, List<String> results,StringBuilder builder, Set<String> wordDict,boolean [] possible){
        if(start==s.length()){
            String result = builder.toString();
            results.add(result.substring(0,result.length()-1));//better to cut off the " " at the result string, do not touch stringbuilder, will affect the upperlevel length trim off
            return;
        }
        int sLength = s.length();
        for(int i=start; i<sLength; i++){
            String sub = s.substring(start,i+1);
            if(wordDict.contains(sub) && possible[i]==true){
                builder.append(sub).append(" ");
                int resultSize = results.size();
                searchWords(s,i+1,results,builder,wordDict,possible);
                builder.setLength(builder.length()-sub.length()-1);
                if(results.size()==resultSize){
                    possible[i]=false;
                }
            }
        }
    }
}