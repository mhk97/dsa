class Node {
    Node links[] = new Node[26];
    boolean flag = false;

    public void put(Node node, char ch) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.containsKey(c) == false) {
                Node node = new Node();
                curr.put(node, c);
            }
            curr = curr.get(c);
        }

        curr.setEnd();
    }

    public boolean search(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.containsKey(c) == false) return false;
            curr = curr.get(c);
        }
        return curr.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.containsKey(c) == false) return false;
            curr = curr.get(c);
        }
        return curr != null;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
