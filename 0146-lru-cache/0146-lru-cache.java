class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int k, int v) {
        key = k;
        val = v;
    }
}

class LRUCache {
    Node head, tail;
    Map<Integer, Node> map;
    int c;

    public LRUCache(int capacity) {
        c = capacity;
        map = new HashMap();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void add(Node temp) {
        Node prev = tail.prev;
        prev.next = temp;
        tail.prev = temp;
        temp.next = tail;
        temp.prev = prev;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);

        remove(node);
        add(node);

        return node.val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            remove(temp);
        }

        Node temp = new Node(key, val);

        map.put(key, temp);
        add(temp);

        if (map.size() > c) {
            Node node = head.next;
            remove(node);
            map.remove(node.key);
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
