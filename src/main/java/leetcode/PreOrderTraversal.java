package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by Stas on 10/25/15.
 */
public class PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preOrderTraversal(list, root);
        return list;
    }


    private void preOrderTraversal(List<Integer> list, TreeNode node) {
        if (node == null) return;
        list.add(node.val);
        preOrderTraversal(list, node.left);
        preOrderTraversal(list, node.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
