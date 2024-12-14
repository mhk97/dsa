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

    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;

        ListNode mid = findMid(head);
        ListNode midNext = reverse(mid.next);

        ListNode first = head, second = midNext;

        while (first != null && second != null) {
            if (first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }

        //restore
        mid.next = reverse(midNext);
        return true;
    }

    public ListNode reverse(ListNode node) {
        ListNode next = null, prev = null, curr = node;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode findMid(ListNode node) {
        ListNode slow = node, fast = node;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
