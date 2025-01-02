import java.util.Arrays;

public class BackgroundClear {
    public static void main(String[] args) {
        Solution S = new Solution();
        int[] answer = S.solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."});
        System.out.println(Arrays.toString(answer));
    }
    private static class Solution {
        public int[] solution(String[] wallpaper) {
            int[] answer = {-1,-1,0,0};

            for(int i = 0; i < wallpaper.length; i++){
                if(wallpaper[i].contains("#")){
                    if(answer[0] == -1) answer[0] = i;
                    if(answer[2] < i+1) answer[2] = i+1;
                    if(answer[1] == -1 || answer[1] > wallpaper[i].indexOf("#")) answer[1] = wallpaper[i].indexOf("#");
                    if(answer[3] < wallpaper[i].lastIndexOf("#") + 1) answer[3] = wallpaper[i].lastIndexOf("#") + 1;
                }
            }
            return answer;
        }
    }
}
