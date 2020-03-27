package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历（非递归）
 */
public class Solution144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur;
        if(root == null){
            return list;
        }
        cur = root;
        while (cur != null ||!stack.isEmpty()) {
            while (cur != null) {
                list.add(cur.val);
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop().right;
        }
        return list;
    }
}
