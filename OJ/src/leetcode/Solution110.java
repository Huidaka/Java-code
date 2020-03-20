package leetcode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 */
public class Solution110 {

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int temp = Math.abs(maxDepth(root.left) - maxDepth(root.right));
        if(temp > 1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        return false;
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftLength = maxDepth(root.left);
        int rightLength = maxDepth(root.right);
        return leftLength > rightLength ? leftLength + 1 : rightLength + 1 ;
    }
}
