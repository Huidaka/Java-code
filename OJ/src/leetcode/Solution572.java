package leetcode;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。
 * s 也可以看做它自身的一棵子树
 */
public class Solution572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null){
            return false;
        }
        if(isSameTree(s,t)){
            return true;
        }
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null && q != null || p != null && q == null){
            return false;
        }
        if(p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }
}
