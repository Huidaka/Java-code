package leetcode;

import java.util.ArrayList;
import java.util.List;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

/**
 * 给定一个二叉树，返回它的 后序 遍历
 */
public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>() ;
        if(root == null){
            return list;
        }
        List<Integer> list1= postorderTraversal(root.left);
        list.addAll(list1);
        List<Integer> list2= postorderTraversal(root.right);
        list.addAll(list2);
        list.add(root.val);
        return list;
    }
}
