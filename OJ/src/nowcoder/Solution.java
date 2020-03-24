package nowcoder;
/**
 * 一个程序，读入用户输入的一串先序遍历字符串，根据此字符串建立一个二叉树（以指针方式存储）。
 * 例如如下的先序遍历字符串： ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树。
 * 建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果。
 */

import java.util.Scanner;
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        TreeNode temp = createBinaryTree(str);
        inOrderTraversal(temp);
    }
    static int i = 0;
    public static TreeNode createBinaryTree(String str){
        if(i == str.length() ||str.charAt(i) == '#' ){
            i++;
            return null;
        }
        TreeNode node = new TreeNode();
        node.val = str.charAt(i);
        i++;
        node.left = createBinaryTree(str);
        node.right = createBinaryTree(str);
        return node;
    }
    public static void  inOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val+" ");
        inOrderTraversal(root.right);
    }
}
class TreeNode{
    public char val;
    public TreeNode left;
    public TreeNode right;
}
