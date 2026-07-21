public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        // Empty tree
        if (root == null)
            return "";

        // Queue for BFS traversal
        Queue<TreeNode> q = new LinkedList<>();

        // Stores serialized string
        StringBuilder res = new StringBuilder();

        // Start from root
        q.add(root);

        while (!q.isEmpty()) {

            // Remove current node
            TreeNode node = q.poll();

            // If node is null, store "n"
            if (node == null) {
                res.append("n ");
                continue;
            }

            // Store node value
            res.append(node.val + " ");

            // Push left and right child
            // (Even if they are null)
            q.add(node.left);
            q.add(node.right);
        }

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        // Empty string means empty tree
        if (data.equals(""))
            return null;

        // Split all values
        String[] values = data.split(" ");

        // Create root
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        // Queue to rebuild tree level by level
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // Start from second element
        for (int i = 1; i < values.length; i++) {

            // Current parent node
            TreeNode parent = q.poll();

            // Create left child if not null
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }

            // Move to right child
            i++;

            // Create right child if not null
            if (i < values.length && !values[i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }

        return root;
    }
}