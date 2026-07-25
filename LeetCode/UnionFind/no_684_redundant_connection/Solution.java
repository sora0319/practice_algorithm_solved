import java.util.Arrays;

class Solution {
    int[] graph = new int[1001];

    public int[] findRedundantConnection(int[][] edges) {
        Arrays.fill(graph, -1);
        int[] result = new int[2];

        for (int[] edge : edges) {
            if (!uni(edge[0], edge[1])) {
                result = edge;
            }
        }

        return result;
    }

    private int find(int node) {
        if (graph[node] >= 0) {
            return graph[node] = find(graph[node]);
        }
        return node;
    }

    private boolean uni(int node1, int node2) {
        int group1 = find(node1);
        int group2 = find(node2);

        if (group1 == group2) {
            return false;
        }

        if (graph[group1] > graph[group2]) {
            int temp = group1;
            group1 = group2;
            group2 = temp;
        }

        if (graph[group1] == graph[group2]) {
            graph[group1]--;
        }

        graph[group2] = group1;

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] edges = {
            {1, 2},
            {1, 3},
            {2, 3}
        };

        int[] result = solution.findRedundantConnection(edges);

        System.out.println(Arrays.toString(result));
    }
}