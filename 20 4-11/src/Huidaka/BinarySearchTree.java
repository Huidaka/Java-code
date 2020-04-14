package Huidaka;

public class BinarySearchTree {

    static class Node {
        public int data;
        public Node left;
        public Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    public Node root = null;

    public Node search(int val) {
        Node cur = root;
        while (cur != null) {
            if(cur.data == val){
                return cur;
            }
            else if(cur.data < val){
                cur = cur.right;
            }
            else{
                cur = cur.left;
            }
        }
        return cur;
    }

    public boolean insert(int key) {
        Node node = new Node(key);
        if(root == null) {
            root = node;
            return true;
        }
        Node parent = null;
        Node cur = root;
        while (cur != null) {
            if(cur.data == key){
                return false;
            }
            else if(cur.data < key){
                parent = cur;
                cur = cur.right;
            }
            else{
                parent = cur;
                cur = cur.left;
            }
        }
        if(parent.data > key){
            parent.left = node;
        }
        if(parent.data < key){
            parent.right = node;
        }
        return true;
    }

    public void remove(int key) {
        Node parent = root;
        Node cur = root;
        while (cur != null) {
            if(cur.data == key) {
                removeNode(parent,cur);
                return;
            }else if(cur.data < key) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
    }
    private void removeNode(Node parent,Node cur) {
        if(cur.left == null) {
            //3种情况
            if(cur == root){
                cur = cur.right;
            }
            else if(cur == parent.left){
                parent.left = cur.right;
            }
            else if(cur == parent.right){
                parent.right = cur.right;
            }
        }else if(cur.right == null) {
            if(cur == root){
                cur = cur.left;
            }
            else if(cur == parent.left){
                parent.left = cur.left;
            }
            else if(cur == parent.right){
                parent.right = cur.left;
            }
        }else {
            Node targetP = cur;
            Node target = cur.right;
            while (target.left != null){
                targetP = target;
                target = target.left;
            }
            cur.data = target.data;
            if(target == targetP.left) {
                targetP.left = target.right;
            }
            if(target == targetP.right){
                targetP.right = target.right;
            }
        }
    }

}

