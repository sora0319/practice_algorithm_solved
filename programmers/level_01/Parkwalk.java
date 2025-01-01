import java.util.ArrayList;
import java.util.List;

public class Parkwalk {
    public static void main(String[] args) {
        Solution s = new Solution();
    }

    private static class Solution {
        public int[] solution(String[] park, String[] routes) {
            int[] answer = new int[2];
            List<Pair> obastacle = new ArrayList<>();

            int H = park.length;
            int W = park[0].length();

            for(int i = 0; i < H; i++ ){
                for(int j = 0; j < W; j++){
                    if(park[i].charAt(j) == 'S'){
                        answer[0] = i;
                        answer[1] = j;
                        continue;
                    }
                    if(park[i].charAt(j) == 'X'){
                        Pair pair = new Pair(i,j);
                        obastacle.add(pair);
                    }
                }
            }

            for(int i = 0; i < routes.length; i++){
                String[] route = routes[i].split(" ");
                Pair moved = new Pair(0,0);
                if(route[0].equals("N")) {
                    moved.x = answer[0] - Integer.parseInt(route[1]);
                    moved.y = answer[1];
                }
                if(route[0].equals("S")){
                    moved.x = answer[0] + Integer.parseInt(route[1]);
                    moved.y = answer[1];
                }
                if(route[0].equals("W")) {
                    moved.x = answer[0];
                    moved.y = answer[1] - Integer.parseInt(route[1]);
                }
                if(route[0].equals("E")){
                    moved.x = answer[0];
                    moved.y = answer[1] + Integer.parseInt(route[1]);
                }

                if(moved.x > W || moved.x < 0 || moved.y > H || moved.y < 0) continue;
                boolean checkObstacle = false;
                for(Pair ob : obastacle){
                    if(route[0] == "N" && moved.y == ob.y && moved.x <= ob.x){
                        checkObstacle = true;
                        break;
                    }
                    if(route[0] == "S" && moved.y == ob.y && moved.x >= ob.x){
                        checkObstacle = true;
                        break;
                    }
                    if(route[0] == "W" && moved.x == ob.x && moved.y <= ob.y){
                        checkObstacle = true;
                        break;
                    }
                    if(route[0] == "E" && moved.x == ob.x && moved.y >= ob.y){
                        checkObstacle = true;
                        break;
                    }
                }
                if(!checkObstacle){
                    answer[0] = moved.x;
                    answer[1] = moved.y;
                }
                System.out.println(answer[0]);
                System.out.println(answer[1]);
            }


            return answer;
        }

        private class Pair{
            int x;
            int y;
            Pair(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
    }
}
