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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), head = dummy;

        int carry = 0, n1 = 0, n2 = 0, sum = 0;

        while (l1 != null || l2 != null || carry > 0) {
            n1 = l1 != null ? l1.val : 0;
            n2 = l2 != null ? l2.val : 0;
            sum = n1 + n2 + carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            dummy.next = newNode;
            dummy = dummy.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return head.next;
    }
}
