import java.util.*;
public class Crane {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int answer = s.solution(board, new int[] {1,5,3,5,1,2,1,4});
        System.out.println(answer);
    }
    private static class Solution {
        public int solution(int[][] board, int[] moves) {
            int N = board.length;
            Stack<Integer> crane = new Stack<>();
            int[] height = new int[N];
            int count = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0 ; j < N; j++){
                    if(board[j][i] != 0){
                        height[i] = j;
                        break;
                    }
                }
            }

            for(int m : moves){
                if(height[m-1] >= N) continue;
                int x = height[m-1];
                int doll = board[x][m-1];

                if(!crane.isEmpty() && crane.peek() == doll){
                    crane.pop();
                    count += 2;
                }
                else{
                    crane.push(doll);
                }
                height[m-1]++;
            }

            return count;
        }
    }
}
