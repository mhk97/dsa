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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1), head = dummy;

        while (list1 != null && list2 != null) {
            ListNode node;
            if (list1.val <= list2.val) {
                node = list1;
                list1 = list1.next;
            } else {
                node = list2;
                list2 = list2.next;
            }

            dummy.next = node;
            dummy = node;
        }

        if (list1 != null) dummy.next = list1; else if (list2 != null) dummy.next = list2;

        return head.next;
    }
}
