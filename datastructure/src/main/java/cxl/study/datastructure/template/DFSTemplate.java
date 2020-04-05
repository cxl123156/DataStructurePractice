package cxl.study.datastructure.template;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class DFSTemplate {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    /**
     * 递归写法
     */
    public void dfsRecursion(Node node, Set visited) {

        // 终止条件
        if (visited.contains(node)) {
            // 以访问过则返回
            return;
        }

        visited.add(node);

        // 处理当前节点
        for (Node child : node.children) {
            if (!visited.contains(child)) {
                dfsRecursion(node, visited);
            }
        }

    }


    public void dfsStack(Node node) {
        if (node == null) {
            return;
        }

        Set visited = new HashSet();
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(node);

        while (!nodeStack.isEmpty()) {
            Node tempNode = nodeStack.pop();

            if (visited.contains(tempNode)) {
                continue;
            }

            visited.add(tempNode);

            if (tempNode.children != null) {
                for (Node child : tempNode.children) {
                    nodeStack.push(child);
                }
            }
        }
    }


    Set<Node> visited = new HashSet<>();

    // 递归
    public void testDFS(Node root) {

        // 终结条件
        if (root.children == null) {
            return;
        }

        System.out.println(root.val);
        visited.add(root);

        for (Node child : root.children) {
            if (!visited.contains(child)) {
                testDFS(child);
            }
        }

    }


    public void testDFSStack(Node root) {
        if (root == null) {
            return;
        }
        Set<Node> visited = new HashSet<>();

        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            Node tempNode = nodeStack.pop();
            if (visited.contains(tempNode)) {
                continue;
            }
            visited.add(tempNode);
            System.out.println(tempNode.val);
            for (Node child : tempNode.children) {
                nodeStack.push(child);
            }
        }

    }


    Set<Node> visitedNode = new HashSet<>();

    /**
     * 递归法
     */
    public void testDFSRecursion2(Node root) {
        //终止条件
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        visitedNode.add(root);

        for (Node child : root.children) {
            if (!visitedNode.contains(child)) {
                testDFSRecursion2(child);
            }
        }
    }

    public  void testDFSStack2(Node root){
        Set<Node> visitedNode = new HashSet<>();
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty()){
            Node tempNode = nodeStack.pop();

            if(visitedNode.contains(tempNode)){
                continue;
            }

            visitedNode.add(tempNode);
            System.out.println(tempNode.val);

            for (Node child : tempNode.children) {
                nodeStack.push(child);
            }
        }
    }


}
