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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if((node.val > p.val && node.val < q.val) || (node.val < p.val && node.val > q.val))
            return node;

        if(node.val == p.val || node.val == q.val)
            return node;

        if(node.val < p.val && node.val < q.val)
            return dfs(node.right, p, q);
        else 
            return dfs(node.left, p, q);
    }
}
