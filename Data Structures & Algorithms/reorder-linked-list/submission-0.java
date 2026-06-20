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
    public void reorderList(ListNode head) {

        if (head == null || head.next == null)
            return;

        // Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the half after middle
        ListNode preMiddle = slow;
        ListNode preCurrent = slow.next;

        while (preCurrent.next != null) {

            ListNode current = preCurrent.next;

            preCurrent.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }

        // Start reordering
        ListNode first = head;
        ListNode second = preMiddle.next;

        while (first != preMiddle) {

            preMiddle.next = second.next;

            second.next = first.next;
            first.next = second;

            first = second.next;
            second = preMiddle.next;
        }
    }
}