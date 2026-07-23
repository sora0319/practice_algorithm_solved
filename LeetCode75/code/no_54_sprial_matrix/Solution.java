package no_54_sprial_matrix;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int direction = 3;

        int[] moveX = {-1, 0, 1, 0};
        int[] moveY = {0, 1, 0, -1};
        boolean[][] visited = new boolean[m][n];
        List<Integer> output = new ArrayList<>();

        int allVisited = 0;
        int x = 0;
        int y = 0;
        visited[x][y] = true;
        output.add(matrix[x][y]);

        while (allVisited < 4) {
            int newX = x + moveX[direction];
            int newY = y + moveY[direction];

            if (newX < 0 || newY < 0 || newX >= m || newY >= n || visited[newX][newY]) {
                direction = (direction + 1) % 4;
                allVisited++;
                continue;
            }

            x = newX;
            y = newY;
            visited[x][y] = true;
            output.add(matrix[x][y]);
            allVisited = 0;
        }

        return output;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        List<Integer> result = solution.spiralOrder(matrix);

        System.out.println(result);
    }
}