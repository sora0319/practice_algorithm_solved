import java.util.HashMap;

public class MBTITest {
    public static void main(String[] args) {
        Solution s = new Solution();
        String answer = s.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
        System.out.println(answer);
    }
    private static class Solution {
        public String solution(String[] survey, int[] choices) {
            StringBuilder sb = new StringBuilder();
            String MBTI = "RTCFJMAN";
            HashMap<Character, Integer> answer = new HashMap<>();

            for(int i = 0; i < MBTI.length(); i++){
                answer.put(MBTI.charAt(i), 0);
            }

            for(int i = 0; i < survey.length; i++){
                int order = choices[i] / 4;
                int score = choices[i] % 4;
                char target = survey[i].charAt(order);

                if(order == 1){
                    answer.put(target, answer.get(target)+score);
                }
                if (order == 0){
                    answer.put(target, answer.get(target)+(4 -score));
                }
            }

            for(int i = 0; i < 8; i +=2){
                if(answer.get(MBTI.charAt(i)) >= answer.get(MBTI.charAt(i+1))){
                    sb.append(MBTI.charAt(i));
                }
                if(answer.get(MBTI.charAt(i)) < answer.get(MBTI.charAt(i+1))){
                    sb.append(MBTI.charAt(i+1));
                }

            }

            return sb.toString();
        }
    }
}
