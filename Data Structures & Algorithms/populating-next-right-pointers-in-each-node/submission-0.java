class Solution {
    public Node connect(Node root) {

        if (root == null)
            return null;

        Node leftMost = root;

        // Traverse level by level
        while (leftMost.left != null) {

            Node curr = leftMost;

            while (curr != null) {

                // Connect left -> right
                curr.left.next = curr.right;

                // Connect right -> next subtree's left
                if (curr.next != null)
                    curr.right.next = curr.next.left;

                curr = curr.next;
            }

            leftMost = leftMost.left;
        }

        return root;
    }
}