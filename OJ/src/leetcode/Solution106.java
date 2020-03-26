package leetcode;

public class Solution106 {
    int pi;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null){
            return null;
        }
        pi = postorder.length-1;
        return  createTree(postorder,inorder, 0, inorder.length-1);

    }
    private TreeNode createTree(int[] postorder, int[] inorder, int begin ,int end){
        if(begin > end || pi < 0){
            return null;
        }
        int pinOindex = getIndex(postorder[pi], inorder, begin,end);
        TreeNode node = new TreeNode(postorder[pi]);
        pi--;
        node.right = createTree(postorder,inorder,pinOindex+1,end);
        node.left = createTree(postorder,inorder,begin,pinOindex-1);
        return node;
    }

    private int getIndex(int val, int[] arr, int first, int last) {
        for (int i = last; i >= first; i--) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
