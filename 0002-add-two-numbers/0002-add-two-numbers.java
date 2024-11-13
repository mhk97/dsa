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
        ListNode ans = new ListNode(100), curr = ans;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int res = n1 + n2 + carry;
            int rem = res % 10;
            carry = res / 10;
            ListNode temp = new ListNode(rem);
            curr.next = temp;
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry == 1) {
            curr.next = new ListNode(carry);
        }

        return ans.next;
    }
}
