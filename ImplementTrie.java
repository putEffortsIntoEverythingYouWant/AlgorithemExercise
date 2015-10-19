/*
Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/

/*
String question: always ask for what letter set
*/
class TrieNode {
    // Initialize your data structure here.
    TrieNode [] children = new TrieNode [26];
        boolean end;
    public TrieNode() {
        
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            TrieNode [] array = node.children;
            char current = word.charAt(i);
            if(array[current-'a']==null){
                array[current-'a'] = new TrieNode();
            }
            node = array[current-'a'];
        }
        node.end = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char current = word.charAt(i);
            TrieNode [] array = node.children;
            if(array[current-'a']==null){
                return false;
            }
            node = array[current-'a'];
        }
        if(node.end==true){
            return true;
        }
        return false;
        
        
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i=0; i<prefix.length(); i++){
            char current = prefix.charAt(i);
            TrieNode [] array = node.children;
            if(array[current-'a']==null){
                return false;
            }
            node = array[current-'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");