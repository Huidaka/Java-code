package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历（非递归）
 */
public class Solution145_1 {
    public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode prev = null;
            TreeNode cur;
            if(root == null){
                return list;
            }
            cur = root;
            while (cur != null ||!stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.peek();
                if(cur.right == null || cur.right == prev){
                    list.add(cur.val);
                    stack.pop();
                    prev = cur;
                    cur = null;
                }
                else{
                    cur = cur.right;
                }
            }
            return list;
        }
}
