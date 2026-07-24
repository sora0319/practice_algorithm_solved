package no_62_unique_paths;

public class Solution {

    public int uniquePaths(int m, int n) {
        int[][] pathCase = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    pathCase[i][j] = 1;
                    continue;
                }

                if (i - 1 >= 0) {
                    pathCase[i][j] += pathCase[i - 1][j];
                }

                pathCase[i][j] += pathCase[i][j - 1];
            }
        }

        return pathCase[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.uniquePaths(3, 7)); // 28
        System.out.println(solution.uniquePaths(3, 2)); // 3
        System.out.println(solution.uniquePaths(7, 3)); // 28
        System.out.println(solution.uniquePaths(3, 3)); // 6
        System.out.println(solution.uniquePaths(1, 1)); // 1
    }
}