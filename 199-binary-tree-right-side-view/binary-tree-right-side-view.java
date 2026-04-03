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
    public List<Integer> rightSideView(TreeNode root) 
    {
        List<Integer> list = new ArrayList<>();

        if(root == null)
        {
            return list;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
            int n = q.size();

            while(n-- > 0)
            {
                TreeNode cur = q.poll();

                if(n == 0)
                {
                    list.add(cur.val);
                }

                if(cur.left != null)
                {
                    q.offer(cur.left);
                }

                if(cur.right != null)
                {
                    q.offer(cur.right);
                }
            }
        }

        return list;
    }
}