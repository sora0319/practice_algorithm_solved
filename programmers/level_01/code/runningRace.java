package code;

import java.util.Arrays;
import java.util.HashMap;


public class runningRace {
    public static void main(String[] args) {
       Solution s = new Solution();
        String[] result = s.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"});
        System.out.println(Arrays.toString(result));
    }

    private static class Solution {
        public String[] solution(String[] players, String[] callings) {
            HashMap<String, Integer> playerLine = new HashMap<>(players.length);
            HashMap<Integer, String>ranks = new HashMap<>(players.length);

            for(int i = 0; i < players.length; i++){
                playerLine.put(players[i],i+1);
                ranks.put(i+1,players[i]);
            }

            for(String player : callings){
                int rank = playerLine.get(player);
                String upRankPlayer = ranks.get(rank-1);

                ranks.replace(rank-1, player);
                ranks.replace(rank, upRankPlayer);

                playerLine.replace(player, rank-1);
                playerLine.replace(upRankPlayer, rank);
            }

            String[] answer = ranks.values().toArray(new String[0]);
            return answer;
        }
    }
}
