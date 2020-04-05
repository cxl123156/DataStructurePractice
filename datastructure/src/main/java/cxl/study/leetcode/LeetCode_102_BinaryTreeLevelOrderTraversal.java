package cxl.study.leetcode;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class LeetCode_102_BinaryTreeLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * BFS 解法
     */
    public List<List<Integer>> levelOrderBFS(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);

        int level = 0;
        while (!treeNodeQueue.isEmpty()) {

            result.add(new ArrayList<>());

            int levelSize = treeNodeQueue.size();
            for (int i = 0; i < levelSize; i++) {

                TreeNode tempNode = treeNodeQueue.poll();
                result.get(level).add(tempNode.val);

                if (tempNode.left != null) {
                    treeNodeQueue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    treeNodeQueue.offer(tempNode.right);
                }
            }
            level++;

        }
        return result;
    }



    private List<List<Integer>> result = new ArrayList<>();

    /**
     * DFS解法
     */
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        dfs(root, 0);
        return result;
    }


    private void dfs(TreeNode root, int level) {

        if (root == null) {
            return;
        }

        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }


}

