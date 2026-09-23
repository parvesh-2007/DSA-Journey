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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        bottomLevel(root, ans);
        return ans;

        
    }
    public static void bottomLevel(TreeNode root, List<List<Integer>>ans){
        if(root== null){
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> level = new ArrayList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            TreeNode currNode = q.remove();
                if(currNode == null){
                    ans.add(0, level);

                    if(q.isEmpty()){
                        break;
                    } else{
                        level = new ArrayList<>();
                        q.add(null);
                    }
                }else{
                        level.add(currNode.val);
            
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }

                } 
        }
    }
}