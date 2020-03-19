package Huidaka;

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        //创建二叉树，返回根节点
        Node root = binaryTree.createTree();
        binaryTree.preOrderTraversal(root);
        System.out.println();
        binaryTree.inOrderTraversal(root);
        System.out.println();
        binaryTree.postOrderTraversal(root);
        System.out.println();
        System.out.println(binaryTree.getSize(root));
        System.out.println("=============叶子=========");
        System.out.println(binaryTree.getLeafSize1(root));
        binaryTree.getLeafSize2(root);
        System.out.println(BinaryTree.LeafSize);
        System.out.println(binaryTree.getKLevelSize(root, 1));
    }
}
