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
        return partition(0, lists.length - 1, lists);
    }

    public ListNode partition(int l, int h, ListNode[] lists) {
        if (l > h) return null;

        if (l == h) return lists[l];

        int mid = l + (h - l) / 2;
        ListNode left = partition(l, mid, lists);
        ListNode right = partition(mid + 1, h, lists);

        return mergeTwoSortedLists(left, right);
    }

    public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoSortedLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoSortedLists(l1, l2.next);
            return l2;
        }
    }
}
