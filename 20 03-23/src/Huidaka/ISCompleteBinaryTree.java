package Huidaka;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断是否是完全二叉树
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}

public class ISCompleteBinaryTree {
    boolean isCompleteTree(TreeNode root){
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (true){
            TreeNode temp = queue.poll();
            if(temp == null){
                break;
            }
            queue.offer(temp.left);
            queue.offer(temp.right);
        }
        while (!queue.isEmpty()){
            if(queue.poll() != null){
                return false;
            }
        }
        return true;
    }
}
