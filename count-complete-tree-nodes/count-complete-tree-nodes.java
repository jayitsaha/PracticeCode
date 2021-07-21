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
    int count = 0;
    public void bst(TreeNode node)
    {
        if(node == null)
        {
            return;
        }
        count++;
        bst(node.left);
        bst(node.right);
    }
    
    
    public int countNodes(TreeNode root) {
        
        bst(root);
        return count;
    }
}