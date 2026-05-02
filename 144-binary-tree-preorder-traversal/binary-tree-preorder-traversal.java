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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s= new Stack<>();
        List<Integer> ans= new ArrayList<>();
        if(root == null) return ans;
        s.push(root);
        
        while(!s.isEmpty()){
            TreeNode cur= s.pop();
            ans.add(cur.val);
            if(cur.right!=null) s.push(cur.right);
            if(cur.left!=null) s.push(cur.left);
        }

        return ans;

    }
}