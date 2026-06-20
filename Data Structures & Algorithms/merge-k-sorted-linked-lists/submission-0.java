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

    public ListNode merge(ListNode l1, ListNode l2){

        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;

        while(l1 != null && l2 != null){

            if(l1.val < l2.val){
                res.next = l1;
                res = l1;
                l1 = l1.next;
            }
            else{
                res.next = l2;
                res = l2;
                l2 = l2.next;
            }
        }

        if(l1 != null)
            res.next = l1;
        else
            res.next = l2;

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0)
            return null;

        ListNode ans = lists[0];

        for(int i = 1; i < lists.length; i++){
            ans = merge(ans, lists[i]);
        }

        return ans;
    }
}