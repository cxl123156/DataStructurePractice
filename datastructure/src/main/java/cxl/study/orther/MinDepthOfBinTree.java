package cxl.study.orther;

public class MinDepthOfBinTree {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public int run(TreeNode root) {
        if(root == null){
            return 0;
        }
        return dfs(root,0);
    }

    private int dfs(TreeNode root,int depth){
        if (root == null){
            return depth;
        }

        int lefDepth = dfs(root.left,depth+1);
        int rightDepth = dfs(root.right,depth+1);
        if(root.left == null){
            return rightDepth;
        }
        if(root.right == null){
            return lefDepth;
        }
        return Math.min(lefDepth,rightDepth);
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        MinDepthOfBinTree minDepthOfBinTree = new MinDepthOfBinTree();
        System.out.println("depth:"+minDepthOfBinTree.run(treeNode));
    }
}
