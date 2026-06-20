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

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */class Solution {
    // Helper function: get the kth node from current position
    private ListNode getKthNode(ListNode temp, int k) {
        int count = 1;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }
        return temp; // if null, means not enough nodes left
    }

    // Helper function: reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev; // new head of the reversed part
    }

    // Main function: reverse nodes in k-group ---
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode temp = head;
        ListNode prevLast = null;

        while (temp != null) {
            // Find kth node from temp
            ListNode kthNode = getKthNode(temp, k);
            if (kthNode == null) {
                // Not enough nodes left → connect and break
                if (prevLast != null) prevLast.next = temp;
                break;
            }

            // Store next segment’s starting node
            ListNode nextNode = kthNode.next;

            // Temporarily break the chain for reversal
            kthNode.next = null;

            // Reverse the current group
            ListNode reversedHead = reverseList(temp);

            // Connect previous group to current reversed one
            if (temp == head) head = reversedHead;
            else prevLast.next = reversedHead;

            // Connect end of reversed group to next segment
            prevLast = temp;
            temp = nextNode;
        }

        return head;
    }
}
