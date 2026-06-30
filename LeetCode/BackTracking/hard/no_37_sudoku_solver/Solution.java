package hard.no_37_sudoku_solver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] cube = new boolean[9][10];
        List<int[]> blanks = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    blanks.add(new int[]{i, j});
                    continue;
                }

                int num = board[i][j] - '0';
                int cubePosition = (i / 3) * 3 + (j / 3);

                row[i][num] = true;
                col[j][num] = true;
                cube[cubePosition][num] = true;
            }
        }

        backtrack(row, col, cube, blanks, board, 0);
    }

    private boolean backtrack(
            boolean[][] row,
            boolean[][] col,
            boolean[][] cube,
            List<int[]> blanks,
            char[][] board,
            int depth
    ) {
        if (depth == blanks.size()) {
            return true;
        }

        int minCount = 10;
        int bestIndex = 0;

        // 아직 채우지 않은 빈칸 중 후보가 가장 적은 칸 선택
        for (int i = depth; i < blanks.size(); i++) {
            int[] checkBlank = blanks.get(i);
            int r = checkBlank[0];
            int c = checkBlank[1];
            int cubePosition = (r / 3) * 3 + (c / 3);

            int count = 0;

            for (int num = 1; num <= 9; num++) {
                if (!row[r][num] && !col[c][num] && !cube[cubePosition][num]) {
                    count++;
                }
            }

            if (count == 0) {
                return false;
            }

            if (minCount > count) {
                minCount = count;
                bestIndex = i;
            }
        }

        // 최소 후보 칸을 현재 depth 위치로 이동
        Collections.swap(blanks, depth, bestIndex);

        int[] checkBlank = blanks.get(depth);
        int r = checkBlank[0];
        int c = checkBlank[1];
        int cubePosition = (r / 3) * 3 + (c / 3);

        for (int num = 1; num <= 9; num++) {
            if (!row[r][num] && !col[c][num] && !cube[cubePosition][num]) {
                row[r][num] = true;
                col[c][num] = true;
                cube[cubePosition][num] = true;
                board[r][c] = (char) ('0' + num);

                if (backtrack(row, col, cube, blanks, board, depth + 1)) {
                    return true;
                }

                // 실패했을 때만 원복
                board[r][c] = '.';
                row[r][num] = false;
                col[c][num] = false;
                cube[cubePosition][num] = false;
            }
        }

        // 이 depth에서 모든 후보가 실패한 경우 리스트 순서도 원복
        Collections.swap(blanks, depth, bestIndex);

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        Solution solution = new Solution();

        System.out.println("풀이 전:");
        printBoard(board);

        solution.solveSudoku(board);

        System.out.println("\n풀이 후:");
        printBoard(board);
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
