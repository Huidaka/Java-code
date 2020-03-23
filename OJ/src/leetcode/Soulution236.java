package leetcode;

/**
 * 二叉树的最近公共祖先
 */
public class Soulution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == q || root == p){
            return root;
        }
        TreeNode Left = lowestCommonAncestor(root.left,p,q);
        TreeNode Right = lowestCommonAncestor(root.right,p,q);
        if(Left != null && Right != null) return root;
        if(Left != null)  return Left;
        if(Right != null) return Right;
        return null;
    }
}
