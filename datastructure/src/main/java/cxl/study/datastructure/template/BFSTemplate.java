package cxl.study.datastructure.template;

import java.util.*;

public class BFSTemplate {

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


    public void bfs(Node start){
        Set<Node> visited = new HashSet<>();
        Deque<Node> nodeDeque = new ArrayDeque<>();
        nodeDeque.push(start);


        while (!nodeDeque.isEmpty()) {
            Node tempNode = nodeDeque.pop();

            if(visited.contains(tempNode)){
                continue;
            }

            visited.add(tempNode);

            process(tempNode);

            if (start.children!=null) {
                for (Node child : start.children) {
                    nodeDeque.push(child);
                }
            }

            // 其他处理逻辑

        }


    }

    private void process(Node tempNode) {
        System.out.println(tempNode.val);
    }

    private void testBfs(Node root){

        if(root == null){
            return;
        }
        Set<Node> visited = new HashSet<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()){
            Node tempNode = nodeQueue.poll();
            System.out.println(tempNode.val);
            visited.add(tempNode);

            if(tempNode.children!=null){
                tempNode.children.forEach(node -> {
                    if(!visited.contains(node)){
                        nodeQueue.offer(node);
                    }
                });
            }
        }

    }

}
