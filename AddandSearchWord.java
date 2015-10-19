/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
*/
/*
when it's string, rememeber to ask the letter range
*/
public class WordDictionary {
    TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word){
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char current = word.charAt(i);
            TrieNode [] children = node.children;
            if(children[current-'a']==null){
                children[current-'a']=new TrieNode();
            }
            node = children[current-'a'];
        }
        node.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchWord(word,root,0);
    }
    //think clear about which node is being checked right now
    public boolean searchWord(String word, TrieNode node, int index){
        if(node==null){
            return false;
        }
        if(index==word.length() && node.isEnd){
            return true;
        }
        if(index>=word.length()){
            return false;
        }
        char current = word.charAt(index);
        TrieNode [] children = node.children;
        if(current!='.'){
            return searchWord(word,children[current-'a'],index+1);
        }else{
            for(int i=0; i<=25; i++){
                if(searchWord(word,children[i],index+1)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public class TrieNode{
        boolean isEnd;
        TrieNode [] children = new TrieNode[26];
        public TrieNode(){
            
        }
    }
    
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");