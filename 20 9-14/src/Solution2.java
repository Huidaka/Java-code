import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
 }
public class Solution2 {
    /**
     *
     * @param node TreeNode类
     */
    public void printNode (TreeNode node) {
        // write code here
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(node != null){
            queue.add(node);
        }
        while (!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            linkedList.add(node1.val);
            if(node1.left != null){
                queue.add(node1.left);
            }
            if(node1.right != null){
                queue.add(node1.right);
            }
        }
        for(int i=0; i<linkedList.size(); i++){
            ArrayList<Integer> arrayList = new ArrayList<>(1);
            lists.add(arrayList);
        }
    }
}
