class Node {
    Node links[] = new Node[26];
    boolean isEnd = false;

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void put(Node n, char c) {
        links[c - 'a'] = n;
    }

    public Node get(char c) {
        return links[c - 'a'];
    }

    public boolean contains(char c) {
        return links[c - 'a'] != null;
    }

    public int countChar() {
        int count = 0;

        for (Node n : links) {
            if (n != null) count++;
        }

        return count;
    }
}

class Solution {
    Node root = new Node();

    public void insert(String s) {
        Node node = root;

        for (char c : s.toCharArray()) {
            if (!node.contains(c)) {
                node.put(new Node(), c);
            }
            node = node.get(c);
        }

        node.setEnd();
    }

    public String longest(String s) {
        Node node = root;
        int i = 0;
        for (char c : s.toCharArray()) {
            if (node.contains(c) && node.countChar() == 1 && node.isEnd() == false) {
                i++;
                node = node.get(c);
            } else break;
        }

        return s.substring(0, i);
    }

    public String longestCommonPrefix(String[] strs) {
        String min = strs[0];

        for (String s : strs) {
            if (min.length() > s.length()) min = s;
            insert(s);
        }

        return longest(min);
    }
}
