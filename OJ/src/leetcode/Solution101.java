package leetcode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode root1, TreeNode root2){
        if(root1 != null && root2 == null || root1 == null && root2 != null){
            return false;
        }
        if(root1 == null && root2 == null){
            return true;
        }
        return root1.val == root2.val && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }
}
