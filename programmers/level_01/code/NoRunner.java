package code;

import java.util.*;

public class NoRunner {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }
    private static class Solution {
        public String solution(String[] participant, String[] completion) {
            Map<String, Integer> runner = new HashMap<>();

            for(int i = 0; i < completion.length; i++){
                int count = 1;
                if(runner.containsKey(completion[i])){
                    count += runner.get(completion[i]);
                }
                runner.put(completion[i],count);
            }


            for(int i = 0; i < participant.length; i++){
                if(!runner.containsKey(participant[i])) return participant[i];
                if(runner.get(participant[i]) == 0) return participant[i];
                runner.put(participant[i], runner.get(participant[i])-1);
            }
            String answer = "";
            return answer;
        }
    }
}
