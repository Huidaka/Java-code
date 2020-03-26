package leetcode;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 */
public class Solution105 {
    public int pi = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null){
            return null;
        }
        return  createTree(preorder,inorder, 0, preorder.length);

    }

    public TreeNode createTree(int[] preorder, int[] inorder, int begin ,int end){
         if(begin > end){
             return null;
         }
         int pinOindex = getIndex(preorder[pi], inorder);
         TreeNode node = new TreeNode(preorder[pi]);
         pi++;
         node.left = createTree(preorder,inorder,begin,pinOindex-1);
         node.right = createTree(preorder,inorder,pinOindex+1,end);
         return node;
    }

    public int getIndex(int val, int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == val){
                return i;
            }
        }
        return -1;
    }

}
