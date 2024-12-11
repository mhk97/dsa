class Node {
    Node links[] = new Node[26];

    boolean flag = false;

    public boolean isEnd() {
        return flag;
    }

    public void setEnd() {
        flag = true;
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public Node getByIndex(int i) {
        return links[i];
    }

    public void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }
}

class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.containsKey(ch) == false) {
                curr.put(ch, new Node());
            }
            curr = curr.get(ch);
        }

        curr.setEnd();
    }

    public boolean search(String word) {
        return searchUtil(word, root);
    }

    public boolean searchUtil(String word, Node node) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (int j = 0; j < 26; j++) {
                    if (node.getByIndex(j) != null && searchUtil(word.substring(i+1, word.length()), node.getByIndex(j)) == true) return true;
                }
                return false;
            }

            if (!node.containsKey(ch)) {
                return false;
            }

            node = node.get(ch);
        }

        return node.isEnd();
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
