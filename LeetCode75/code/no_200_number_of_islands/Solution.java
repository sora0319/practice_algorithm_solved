package no_200_number_of_islands;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int island = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(visited, grid, new Land(i, j));
                    island++;
                }
            }
        }

        return island;
    }

    private void bfs(boolean[][] visited, char[][] grid, Land land) {
        Queue<Land> queue = new LinkedList<>();

        int[] moveX = {-1, 0, 0, 1};
        int[] moveY = {0, 1, -1, 0};

        queue.offer(land);

        while (!queue.isEmpty()) {
            Land newLand = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = newLand.x + moveX[i];
                int newY = newLand.y + moveY[i];

                if (newX < 0 || newY < 0
                        || newX >= grid.length
                        || newY >= grid[0].length) {
                    continue;
                }

                if (grid[newX][newY] == '0') {
                    continue;
                }

                if (visited[newX][newY]) {
                    continue;
                }

                queue.offer(new Land(newX, newY));
                visited[newX][newY] = true;
            }
        }
    }

    public static class Land {
        int x;
        int y;

        Land(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(solution.numIslands(grid1)); // 1
        System.out.println(solution.numIslands(grid2)); // 3
    }
}