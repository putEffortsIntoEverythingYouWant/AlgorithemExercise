/*
Given two words (beginWord and endWord), and a dictionary, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/
public class Solution {
    //barely passed time limits...
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        
        int level = 1;
        LinkedList<String> queue = new LinkedList<String>();//can not use list<String>
        Set<String> visited = new HashSet<String>();
        queue.add(beginWord);
        int totalNum = 1;
        int neighborNum = 0;
        while(!queue.isEmpty()){
            String current = queue.removeFirst();
            totalNum--;
            char[] chars = current.toCharArray();
            for(int i=0; i<chars.length; i++){
                for(char ch='a'; ch<='z'; ch++){//find neighbors in graph(meaning: word with one step change exists in wordDict)
                    char temp = chars[i];
                    if(chars[i]==ch){
                        continue;
                    }
                    chars[i] = ch;
                    String toMatch = new String(chars);
                    if(toMatch.equals(endWord)){
                        return level+1;
                    }
                    if(wordDict.contains(toMatch)){
                        if(!visited.contains(toMatch)){
                            queue.addLast(toMatch);
                            neighborNum++;//records num of neighbor to control level numbers
                            visited.add(toMatch);
                        }
                        
                    }
                    chars[i]=temp;//change it back
                }
            }
            if(totalNum==0){//iterated over one level, go to next level
                totalNum = neighborNum;
                neighborNum=0;
                level++;
            }
        }
        
        return 0;
    }
}