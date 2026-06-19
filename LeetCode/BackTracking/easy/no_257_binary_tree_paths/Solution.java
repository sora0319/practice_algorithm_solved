package no_257_binary_tree_paths;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        /*
            테스트 트리:

                1
               / \
              2   3
               \
                5

            expected: ["1->2->5", "1->3"]
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        Solution sol = new Solution();

        List<String> result = sol.binaryTreePaths(root);

        System.out.println(result);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> checkLink = new ArrayList<>();
        List<String> paths = new ArrayList<>();

        if (root == null) {
            return paths;
        }

        checkingLinks(root, checkLink, paths);

        return paths;
    }

    private void checkingLinks(TreeNode node, List<Integer> checkLink, List<String> paths) {
        checkLink.add(node.val);

        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < checkLink.size(); i++) {
                sb.append(checkLink.get(i));

                if (i != checkLink.size() - 1) {
                    sb.append("->");
                }
            }

            paths.add(sb.toString());

            checkLink.remove(checkLink.size() - 1);
            return;
        }

        if (node.left != null) {
            checkingLinks(node.left, checkLink, paths);
        }

        if (node.right != null) {
            checkingLinks(node.right, checkLink, paths);
        }

        checkLink.remove(checkLink.size() - 1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}