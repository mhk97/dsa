class Node {
    private Node links[] = new Node[26];
    private boolean isEnd = false;

    public void setEnd() {
        isEnd = true;
    }

    public boolean getEnd() {
        return isEnd;
    }

    public boolean containsKey(char c) {
        return links[c - 'a'] != null;
    }

    public void insert(char c, Node node) {
        links[c - 'a'] = node;
    }

    public Node next(char c) {
        return links[c - 'a'];
    }
}

class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node temp = root;
        for (char c : word.toCharArray()) {
            if (!temp.containsKey(c)) {
                Node newNode = new Node();
                temp.insert(c, newNode);
            }
            temp = temp.next(c);
        }

        temp.setEnd();
    }

    public boolean search(String word) {
        Node temp = root;

        return search(temp, word);
    }

    public boolean search(Node temp, String word) {
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);

            if (curr == '.') {
                for (char j = 'a'; j <= 'z'; j++) {
                    if (temp.containsKey(j) && search(temp.next(j), word.substring(i + 1, word.length())) == true) return true;
                }

                return false;
            }

            if (!temp.containsKey(curr)) {
                return false;
            }

            temp = temp.next(curr);
        }

        return temp.getEnd();
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
