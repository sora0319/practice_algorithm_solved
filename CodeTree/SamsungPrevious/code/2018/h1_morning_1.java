import java.io.*;
import java.util.*;

public class h1_morning_1 {
    static int[] X = {-1, 0, 1, 0};
    static int[] Y = {0, 1, 0, -1};

    static int[][][] moving = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0,2}, {1,3}},
            {{0,1}, {1,2}, {2,3}, {3,0}},
            {{0,1,2}, {1,2,3}, {2,3,0}, {3,0,1}},
            {{0,1,2,3}}
    };

    static int minCount = 0;
    static int n = 0;
    static int m = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Position> chessPieces = new ArrayList<>();

        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        int[][] board = new int[n][m];
        int[][] visited = new int[n][m];
        minCount = n*m;
        int count = 0;

        for(int i = 0; i < n; i++){
            inputs = br.readLine().split(" ");

            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(inputs[j]);

                if(board[i][j] == 0){
                    count++;
                    continue;
                }

                if(board[i][j] < 6){
                    Position piece = new Position(i, j, board[i][j]);
                    chessPieces.add(piece);
                }
            }
        }

        Collections.sort(chessPieces);
        backtrack(count, 0, board, visited, chessPieces);

        bw.write(String.valueOf(minCount));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void backtrack(int count, int movingPiece, int[][] board, int[][]visited, List<Position> chessPieces){
        if(movingPiece == chessPieces.size()){
            if(minCount > count){
                minCount = count;
            }
            return;
        }

        Position piece = chessPieces.get(movingPiece);
        int[][] moved = moving[piece.type];

        for(int[] mo : moved){
            for(int direction : mo){
                int moveX = piece.x;
                int moveY = piece.y;

                while(true){
                    moveX += X[direction];
                    moveY += Y[direction];

                    if(moveX < 0 || moveY < 0 || moveX >= n || moveY >= m) break;
                    if(board[moveX][moveY] == 6) break;
                    if(board[moveX][moveY] == 0){
                        if(visited[moveX][moveY] == 0){
                            count--;
                        }
                        visited[moveX][moveY]++;
                    }
                }
            }

            backtrack(count, movingPiece + 1, board, visited, chessPieces);

            for(int direction : mo){
                int moveX = piece.x;
                int moveY = piece.y;

                while(true){
                    moveX += X[direction];
                    moveY += Y[direction];

                    if(moveX < 0 || moveY < 0 || moveX >= n || moveY >= m) break;
                    if(board[moveX][moveY] == 6) break;
                    if(board[moveX][moveY] == 0){
                        if(visited[moveX][moveY] -1 == 0){
                            count++;
                        }
                        visited[moveX][moveY]--;
                    }
                }
            }
        }

    }






    static class Position implements Comparable<Position>{
        int x;
        int y;
        int type;

        Position(int x, int y, int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }

        public int compareTo(Position other){
            if(this.type > other.type) return -1;
            if(this.type == other.type) return 0;
            return 1;
        }
    }
}
