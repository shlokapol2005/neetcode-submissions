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
 //CODESTORYWITHMIK VIDEO 
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root); //push root in queeu

        boolean pastseennull = false;

        while(!q.isEmpty()){
            TreeNode node = q.poll(); //store the popped node
        

            if(node == null){
                pastseennull = true;
            } else{
                if(pastseennull == true)
                return false;
            
            q.offer(node.left);  //push
            q.offer(node.right);   //push

        }
    }
    return true;
}
}