/*
Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
*/
public class Solution {
    	public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
            //store all neighbors and backtracking not a good approach because it basically equals to a DFS..so put path into queue, the last word is the one we actually search for 
            LinkedList<List<String>> queue = new LinkedList<List<String>>();
            Set<String> visited  = new HashSet<String>();
            List<String> startList = new ArrayList<String>();
            startList.add(start);
            queue.addLast(startList);
            List<String> currentLevelNewNode = new ArrayList<String>();
            List<List<String>> results = new ArrayList<List<String>>();
            boolean found = false;
            int level=1;
            int totalNum = 1;
            int currentNum = 0;
            while(!queue.isEmpty()){
                List<String> current = queue.removeFirst();
                totalNum--;
                char[] chars = current.get(current.size()-1).toCharArray();
                for(int i=0; i<chars.length; i++){
                    for(char c = 'a'; c<='z'; c++){
                        char old = chars[i];
                        chars[i]=c;
                        String newString = new String(chars);
                        if(newString.equals(end)){//don't check dict, because end doesn't have to be in the dict
                            current.add(newString);
                            results.add(current);
                            found = true;
                        }
                        if(dict.contains(newString)){
                            if(!visited.contains(newString)){
                                List<String> newList = new ArrayList<String>();
                                newList.addAll(current);
                                newList.add(newString);
                                queue.addLast(newList);
                                currentNum++;
                                currentLevelNewNode.add(newString);//allow duplicates in one level to include all diff paths
                                //if diff paths go to same node, they have to hit the same node at the same level
                            }
                        }
                        chars[i]=old;
                    }
                }

                if(totalNum==0){
                    if(found == true){//already found, no need to go further
                    break;
                     }
                    level++;
                    totalNum=currentNum;
                    currentNum=0;
                    visited.addAll(currentLevelNewNode);
                }
            }  
    return results;
         }
 

}