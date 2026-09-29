class Trie {

    Trie[] childern;
    boolean isEnd;

    public Trie() {
        childern = new Trie[26];
        isEnd = false;
    }
    
    public void insert(String word) {
        Trie current = this;

        for(int i = 0; i < word.length();i++){
            int index = word.charAt(i) - 'a';

            if(current.childern[index] == null){
                current.childern[index] = new Trie();
            }
            current = current.childern[index];
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie current = this;

        for(int i = 0; i < word.length();i++){
            int index = word.charAt(i) -'a';

            if(current.childern[index] == null){
                return false;
            }
            current = current.childern[index];
        }
        return current.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Trie current = this;

        for(int i = 0; i < prefix.length();i++){
            int index =  prefix.charAt(i) - 'a';

            if(current.childern[index] == null){
                return false;
            }
            current = current.childern[index];
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