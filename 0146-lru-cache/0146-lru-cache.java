class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    Node head, tail;
    Map<Integer, Node> map;
    int capacity = 0;

    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap();
        this.capacity = capacity;
    }

    private void add(Node node) {
        Node prevTemp = tail.prev;
        prevTemp.next = node;
        tail.prev = node;
        node.next = tail;
        node.prev = prevTemp;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        // remove and add at back
        Node temp = map.get(key);
        remove(temp);
        add(temp);

        return temp.value;
    }

    public void put(int key, int value) {
        //removed from list
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        Node node = new Node(key, value);
        map.put(key, node);
        add(node);

        if (map.size() > capacity) {
            Node temp = head.next;
            remove(temp);
            map.remove(temp.key);
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
