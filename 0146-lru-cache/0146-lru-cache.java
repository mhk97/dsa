class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int k, int v) {
        key = k;
        value = v;
    }
}

class LRUCache {
    Map<Integer, Node> map;
    Node head, tail;
    int c;

    public LRUCache(int capacity) {
        c = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap();
    }

    public void add(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        tail.prev = node;
        node.next = tail;
        node.prev = prev;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node temp = map.get(key);

        remove(temp);
        add(temp);

        return temp.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            remove(temp);
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        add(newNode);

        if (map.size() > c) {
            Node temp = head.next;
            map.remove(temp.key);
            remove(temp);
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
