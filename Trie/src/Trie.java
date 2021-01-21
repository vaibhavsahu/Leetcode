class Trie {

    Node node;

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(node == null){
            return false;
        }

        int i = 0;

        while (node != null){
            if(node.isCompleteWord){
                return true;
            }

           // if(word.charAt(i) == node.getChildren().)

        }

        for (int i = 0; i < word.length(); i++) {
            if(node.getChildren().containsKey(word.charAt(i))){
                node = node.getChildren().get(word.charAt(i));
            }
        }

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(node == null){
            return false;
        }


    }
}
