package code;

import java.util.Arrays;
import java.util.HashMap;

public class yearningScore {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3},
                new String[][]{
                        {"may", "kein", "kain", "radi"},
                        {"may", "kein", "brin", "deny"},
                        {"kon", "kain", "may", "coni"}
                });
        System.out.println(Arrays.toString(result));
    }
    private static class Solution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {
            int[] answer = new int[photo.length];
            HashMap<String, Integer> score = new HashMap<>();

            for(int i = 0; i < name.length; i++){
                score.put(name[i], yearning[i]);
            }

            for(int i = 0; i < photo.length; i++){
                int total = 0;
                for(String n : photo[i]){
                    if(score.containsKey(n)){
                        total += score.get(n);
                    }
                }
                answer[i] = total;
            }


            return answer;
        }
    }
}
