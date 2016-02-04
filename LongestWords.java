/*
Given a dictionary, find all of the longest words in the dictionary.

Have you met this question in a real interview? Yes
Example
Given

{
  "dog",
  "google",
  "facebook",
  "internationalization",
  "blabla"
}
the longest words are(is) ["internationalization"].

Given

{
  "like",
  "love",
  "hate",
  "yes"
}
the longest words are ["like", "love", "hate"].

Challenge
It's easy to solve it in two passes, can you do it in one pass?
*/

class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
        
        ArrayList<String> result = new ArrayList<String>();
        if(dictionary==null){
            return result;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<dictionary.length; i++){
            String current = dictionary[i];
            if(current.length()==max){
                result.add(current);
                
            }else if(current.length()>max){
                result.clear();
                max = current.length();
                result.add(current);
            }
        }
        return result;
    }
};
