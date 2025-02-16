package code;

import java.util.Arrays;
import java.util.HashMap;

public class RoughlyKeyboard {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] answer = s.solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD","AABB"});
        System.out.println(Arrays.toString(answer));
    }

    private static class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] result = new int[targets.length];
            HashMap<Character, Integer> keys = new HashMap<>();
            int cnt = 0;

            for(String s : keymap){
                for(int i = 0; i < s.length(); i++){
                    char button = s.charAt(i);
                    if(!keys.containsKey(button) || (keys.containsKey(button) && keys.get(button) > i+1)){
                        keys.put(button, i+1);

                    }
                }
            }

            for(int t = 0; t < targets.length; t++){
                for(int i = 0; i < targets[t].length(); i++){

                    char targetChar = targets[t].charAt(i);
                    if(!keys.containsKey(targetChar)){
                        cnt = -1;
                        break;
                    }
                    cnt += keys.get(targetChar);
                }
                result[t] = cnt;
                cnt = 0;
            }

            return result;
        }
    }
}
