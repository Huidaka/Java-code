package Huidaka;

import javax.print.DocFlavor;

/**
 * 实现二叉树的遍历和子问题
 */
class Node{
    public Node left;
    public Node right;
    public char val;

    public Node(char val) {
        this.left = null;
        this.right = null;
        this.val = val;
    }
}
public class BinaryTree {
    public Node createTree() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right= G;
        E.right = H;
        return A;
    }

    /**
     *  前序遍历
     * @param root
     */
    public void preOrderTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /**
     * 中序遍历
     * @param root
     */
    public void  inOrderTraversal(Node root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val);
        inOrderTraversal(root.right);
    }

    /**
     * 后序遍历
     * @param root
     */
    public void postOrderTraversal(Node root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val);
    }

    /**
     * 子问题
     */

    /**
     * 节点个数
     * @param root
     * @return
     */
    public int getSize(Node root){
        if(root == null){
            return 0;
        }
        return getSize(root.left) + getSize(root.right) + 1;
    }

    /**
     * 返回叶子节点个数
     * @param root
     * @return
     */
    public int getLeafSize1(Node root){
        if(root == null){
            return 0;
        }
        if(root.right == null && root.left == null){
            return 1;
        }
        return getLeafSize1(root.left) + getLeafSize1(root.right);
    }

    /**
     * 返回叶子节点个数（静态变量）
     * @param root
     * @return
     */
    static int LeafSize = 0;
    public void getLeafSize2(Node root){
        if(root == null){
            return;
        }
        if(root.right == null && root.left == null){
            LeafSize++;
            return;
        }
        getLeafSize2(root.left);
        getLeafSize2(root.right);
        return;
    }

    /**
     *
     * @param root
     * @param k
     * @return 返回第k层的节点个数
     */
    public int getKLevelSize(Node root,int k){
        if(root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return getKLevelSize(root.right,k-1) + getKLevelSize(root.left,k-1);
    }
}