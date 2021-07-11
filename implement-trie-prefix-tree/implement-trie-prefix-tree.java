class TriNode{
    TriNode[] children = new TriNode[26];
    boolean isEnd = false;
}

class Trie {

    /** Initialize your data structure here. */
    TriNode root; 
    public Trie() {
        root = new TriNode();
    }
    
    /** Inserts a word into the trie. */
     public void insert(String word) {
        TriNode node = root;
        for (int i =0; i <word.length(); i++){
            char c = word.charAt(i);
            if (node.children[c-'a'] == null){
                node.children[c-'a'] = new TriNode();
            }
            node = node.children[c-'a'];
        }
        node.isEnd = true;
    }
    /** Returns if the word is in the trie. */
     public boolean search(String word) {
        TriNode node = root;
        for (int i =0; i <word.length(); i++){
            char c = word.charAt(i);
            if (node.children[c-'a'] == null)
                return false;
            node = node.children[c-'a'];
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TriNode node = root;
        for (int i =0; i <prefix.length(); i++){
            char c = prefix.charAt(i);
            if (node.children[c-'a'] == null)
                return false;
            node = node.children[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */