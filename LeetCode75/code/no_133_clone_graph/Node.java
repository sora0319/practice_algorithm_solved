package no_133_clone_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> savedNode = new HashMap<>();

        return createNode(node, savedNode);
    }

    private Node createNode(Node oldNode, Map<Node, Node> savedNode) {
        if (oldNode == null) {
            return null;
        }

        if (savedNode.containsKey(oldNode)) {
            return savedNode.get(oldNode);
        }

        Node newNode = new Node(oldNode.val);
        savedNode.put(oldNode, newNode);

        List<Node> newNeighbors = newNode.neighbors;

        for (Node neighbor : oldNode.neighbors) {
            newNeighbors.add(createNode(neighbor, savedNode));
        }

        return newNode;
    }

    public static void main(String[] args) {
        /*
         * 그래프 구조
         *
         * 1 ---- 2
         * |      |
         * 4 ---- 3
         */

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Solution solution = new Solution();

        Node clonedNode = solution.cloneGraph(node1);

        System.out.println("원본 그래프");
        printGraph(node1);

        System.out.println("복제 그래프");
        printGraph(clonedNode);

        System.out.println(
            "원본과 복제 노드가 같은 객체인가? " + (node1 == clonedNode)
        );
    }

    private static void printGraph(Node startNode) {
        if (startNode == null) {
            System.out.println("빈 그래프");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        queue.offer(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            System.out.print(currentNode.val + "의 이웃: ");

            for (Node neighbor : currentNode.neighbors) {
                System.out.print(neighbor.val + " ");

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }

            System.out.println();
        }

        System.out.println();
    }
}