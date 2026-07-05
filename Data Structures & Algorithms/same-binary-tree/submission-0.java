/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if both are null then same
        if (p == null || q == null) {
            return p == q;
        }


//preorder
        // both non-null here
        return (p.val == q.val) //root
                && isSameTree(p.left, q.left)//left
                && isSameTree(p.right, q.right); //right
    }
}