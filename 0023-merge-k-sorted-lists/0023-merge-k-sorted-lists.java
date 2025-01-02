/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return partition(lists, 0, lists.length - 1);
    }

    public ListNode partition(ListNode[] lists, int l, int h) {
        if (l >= h) return lists[l];

        int mid = l + (h - l) / 2;

        ListNode first = partition(lists, l, mid);
        ListNode second = partition(lists, mid + 1, h);

        return merge2sortedList(first, second);
    }

    public ListNode merge2sortedList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = merge2sortedList(l1.next, l2);
            return l1;
        } else {
            l2.next = merge2sortedList(l1, l2.next);
            return l2;
        }
    }
}
