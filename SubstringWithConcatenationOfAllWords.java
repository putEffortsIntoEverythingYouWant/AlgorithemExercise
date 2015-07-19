/*
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/
public class Solution {
    //checking words by bucket only works when there is no overlapping on words...for example"aaaa",[a][a] can not detect the middle aa...
    //if advance index by 1 doesn't work because it break the records we are maintaining
    //therefore, we can bucket by required setence length and advance index by 1; for each sentence check if qualified, if not break, if yes add to result
    public List<Integer> findSubstring(String S, String[] L) {
        if(L==null || L.length==0 || S==null || S.length()<L[0].length()){
            return new ArrayList<Integer>();
        }
        int length = L[0].length();
        
        Map<String,Integer> record = new HashMap<String,Integer>();
        for(int i=0; i<L.length; i++){
            if(record.containsKey(L[i])){
                record.put(L[i],record.get(L[i])+1);
            }else{
                record.put(L[i],1);
            }
        }
        List<Integer> results = new ArrayList<Integer>();
        int stringLength = S.length();
        int totalLength = length*L.length;
        for(int start=0; start<=stringLength-totalLength; start++){
            Map<String,Integer> cloned = cloneMap(record);
            int end = start+totalLength;
            String segment = S.substring(start,end);
            int current = 0;
            int segLength = segment.length();
            while(current<=segLength-length){
                int wordEnd = current+length;
                String word = segment.substring(current,wordEnd);
                if(!cloned.containsKey(word) || cloned.get(word)==0){
                    break;
                }
                cloned.put(word,cloned.get(word)-1);
                if(cloned.get(word)==0){
                    cloned.remove(word);
                }
                current = wordEnd;
            }
            if(current==segLength && cloned.isEmpty()){
                results.add(start);
            }
            
        }
        return results;
       
    }
    
    public Map<String,Integer> cloneMap(Map<String,Integer> map){
        Map<String,Integer> results = new HashMap<String,Integer>();
        Set<String> keys = map.keySet();
        for(String key: keys){
            results.put(key,map.get(key));
        }
        return results;
    }
}