class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return ans;
    }
}