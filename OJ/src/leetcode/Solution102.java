package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历二叉树
 */
public class Solution102 {

    public void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.println(cur.val);
            if(cur != null) {
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
    }
}
