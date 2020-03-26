package leetcode;

import javax.swing.*;

/**根据二叉树创建字符串
 *
 */
public class Solution606 {

    public String tree2str(TreeNode t) {
        StringBuffer str  = new StringBuffer();
        helper(t,str);
        return str.toString();
    }

    private void helper(TreeNode root, StringBuffer str){
        if(root == null){
            return;
        }
        str.append(root.val);
        if(root.left == null){
            if(root.right == null){
                return;
            }
            else {
                str.append("()");
            }
        }
        else{
            str.append("(");
            helper(root.left,str);
            str.append(")");
        }
        if(root.right == null){
            return;
        }
        else{
            str.append("(");
            helper(root.right,str);
            str.append(")");
        }
    }
}
