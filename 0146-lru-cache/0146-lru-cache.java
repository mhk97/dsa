class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    Node head, tail;
    HashMap<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;

        map = new HashMap();
    }

    public void addAtBack(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        tail.prev = node;
        node.next = tail;
        node.prev = prev;
    }

    public void removeFromFront(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node temp = map.get(key);
        removeFromFront(temp);
        addAtBack(temp);

        return temp.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            removeFromFront(temp);
        }

        Node node = new Node(key, value);
        addAtBack(node);
        map.put(key, node);

        if (map.size() > capacity) {
            Node temp = head.next;
            map.remove(temp.key);
            removeFromFront(temp);
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
