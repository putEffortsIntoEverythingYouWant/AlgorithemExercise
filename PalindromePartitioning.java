/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/
public class Solution {
    /*
    simple recursion that covers all combination and for each substring, check if it is palindrome
    */
    
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<List<String>>();
        if(s==null){
            return results;
        }
        List<String> current = new ArrayList<String>();
        combineSubstring(s,0,results,current);
        return results;
        
    }
    
    public void combineSubstring(String s, int start, List<List<String>> results, List<String> current){
        if(start>=s.length()){
            List<String> copyOfCurrent = new ArrayList<String>();
            copyOfCurrent.addAll(current);
            //make sure to create deep copy of the list and add it
            //last element of current will be removed after each recursion level and eventually current will be empty
            results.add(copyOfCurrent);
        }
        for(int end = start+1; end <= s.length(); end++){
            String subString = s.substring(start,end);
            if(isPalindrome(subString)){
                current.add(subString);
                combineSubstring(s,end,results,current);
                current.remove(current.size()-1);
                
            }
        }
        
    }
    private boolean isPalindrome(String str){
        int start = 0;
        int end = str.length()-1;
        while(start<=end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}