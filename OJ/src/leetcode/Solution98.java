package leetcode;

/**
 * 验证二叉搜索树
 */
public class Solution98 {
    long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return isValidBST(root.left) && visit(root) && isValidBST(root.right);
    }
    public boolean visit(TreeNode root){
        if(root.val > prev){
            prev = root.val;
            return true;
        }
        else{
            return false;
        }
    }
}
