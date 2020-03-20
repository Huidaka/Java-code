package leetcode;

/**
 * 返回二叉树的最大深度
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftLength = maxDepth(root.left);
        int rightLength = maxDepth(root.right);
        return leftLength > rightLength ? leftLength + 1 : rightLength + 1 ;
    }

}
