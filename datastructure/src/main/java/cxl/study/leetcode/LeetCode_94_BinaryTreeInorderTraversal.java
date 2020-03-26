package cxl.study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class LeetCode_94_BinaryTreeInorderTraversal {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        this.traversalTree(root);
        return result;
    }

    public void traversalTree(TreeNode root){
        if(root!=null){
            // 下钻递归调用
            traversalTree(root.left);
            // 处理逻辑
            result.add(root.val);
            traversalTree(root.right);
            // 终止条件
            if(root.left == null && root.right == null){
                return;
            }
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
