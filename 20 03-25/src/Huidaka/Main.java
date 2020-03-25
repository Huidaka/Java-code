package Huidaka;

/**
 * 给定一棵满二叉树，判定该树是否为二叉搜索树，是的话打印True，不是的话打印False
 */

import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
    }
}
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(str.equals("None")){
            System.out.println("True");
            return;
        }
        String[] s = str.split(",");
        int[] arr = new int[s.length];
        for(int i = 0; i<arr.length; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        TreeNode root = createTreeNode(arr);
        if(isValidBST(root)){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }
    static int i = 0;
    public static TreeNode createTreeNode(int[] arr){
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[i++]);
        queue.offer(root);
        while(!queue.isEmpty() && i<arr.length-1){
            TreeNode cur = queue.poll();
            cur.left = new TreeNode(arr[i++]);
            cur.right = new TreeNode(arr[i++]);
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return root;
    }
    static int prev = Integer.MIN_VALUE;
    public static Boolean isValidBST(TreeNode root){
        if(root == null){
            return true;
        }
        return isValidBST(root.left) && visit(root) && isValidBST(root.right);
    }
    public static boolean visit(TreeNode root){
        if(root.val > prev){
            prev = root.val;
            return true;
        }
        else{
            return false;
        }
    }
}

