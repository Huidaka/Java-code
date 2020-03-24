package nowcoder;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向
 */
public class Soulution3 {

    public TreeNode Convert(TreeNode pRootOfTree){
        if(pRootOfTree == null){
            return null;
        }
        ConvertChild(pRootOfTree);
        TreeNode ret = pRootOfTree;
        while (ret.left != null){
            ret = ret.left;
        }
        return ret;
    }

    public TreeNode prev = null;

    public void ConvertChild(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return;
        }
        ConvertChild(pRootOfTree.left);
        pRootOfTree.left = prev;
        if(prev != null) {
            prev.right = pRootOfTree;
        }
        prev = pRootOfTree;
        ConvertChild(pRootOfTree.right);
    }
}
