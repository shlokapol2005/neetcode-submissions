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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head == null || left == right)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;  //to preserve head and handle case if left is the first node then prev dummy hojagyega 

        // find leftPrev
        ListNode leftPrev = dummy;

        for(int i = 1; i < left; i++){
            leftPrev = leftPrev.next;
        }

        // left node
        ListNode leftNode = leftPrev.next;

        // find right node
        ListNode rightNode = leftNode;

        for(int i = left; i < right; i++){
            rightNode = rightNode.next;
        }

        // save right next
        ListNode rightNext = rightNode.next;

        // cut the sublist
        rightNode.next = null;

        // reverse [left...right]
        ListNode prev = null;
        ListNode curr = leftNode;

        while(curr != null){
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // reconnect
        leftPrev.next = prev;      // new head of reversed part
        leftNode.next = rightNext; // old head becomes tail

        return dummy.next;
    }
}