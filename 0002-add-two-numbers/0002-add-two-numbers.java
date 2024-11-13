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
        ListNode carry = new ListNode(0), ans = new ListNode(100), curr = ans;

        while (l1 != null && l2 != null) {
            int res = l1.val + l2.val + carry.val;
            int rem = res % 10;
            carry.val = res / 10;
            ListNode temp = new ListNode(rem);
            curr.next = temp;
            curr = curr.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode l3 = l1 == null ? l2 : l1;

        while (l3 != null) {
            int res = l3.val + carry.val;
            int rem = res % 10;
            carry.val = res / 10;
            ListNode temp = new ListNode(rem);
            curr.next = temp;
            curr = curr.next;

            l3 = l3.next;
        }

        if (carry.val == 1) {
            curr.next = new ListNode(carry.val);
        }

        return ans.next;
    }
}
