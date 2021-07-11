class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(!wordList.contains(endWord)) return 0;
        
        HashMap<String, Boolean> vmap = new HashMap<String,Boolean>();
        
        for(int i=0;i<wordList.size(); i++)
            vmap.put(wordList.get(i),false);
        
        Queue<String> q = new LinkedList<String>();
        
        int length = 1;
        q.add(beginWord);
        
        
        vmap.put(beginWord,true);
        
//      BFS 
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i=0;i<size;i++){
                String w = q.poll();
                if(w.equals(endWord))
                    return length;
//              Will give each char(from a-z) a fair chance to compete for candidacy
//              and find if with just one change in the word, it matches wordList
//              if it does add to BFS queue, and continue process
//              BFS is a must as minimum steps is required
                wordMatch(w,vmap,q);
            }
            length++;
        }
        return 0;
        
    }
    
    public void wordMatch(String w, HashMap<String, Boolean> Vmap, Queue<String> q) {
        for (int i = 0; i < w.length(); i++) {
            char[] word = w.toCharArray();
            for (int j = 0; j < 26; j++) {
                char c = (char) ('a' + j);
                word[i] = c;
                String s = String.valueOf(word);
                if (Vmap.containsKey(s) && Vmap.get(s) == false) {
                    q.add(s);
                    Vmap.put(s, true);
                }
            }
        }
    }
    

}