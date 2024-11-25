/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap();

        Node curr = head;

        while (curr != null) {
            Node newNode = new Node(curr.val, null, null);
            map.put(curr, newNode);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node temp = map.get(curr);
            temp.next = (map.containsKey(curr)) ? map.get(curr.next) : null;
            temp.random = (map.containsKey(curr)) ? map.get(curr.random) : null;
            curr = curr.next;
        }

        return map.get(head);
    }
}
