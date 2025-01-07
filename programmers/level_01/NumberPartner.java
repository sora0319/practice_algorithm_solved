import java.util.HashMap;

public class NumberPartner {
    public static void main(String[] args) {
        Solution s = new Solution();
        String answer = s.solution("12321", "42531");
        System.out.println(answer);
    }

    private static class Solution {
        public String solution(String X, String Y) {
            HashMap<String, Integer> Xnumbers = new HashMap<>();
            HashMap<String, Integer> Ynumbers = new HashMap<>();
            StringBuffer BigNumber = new StringBuffer();

            int maxLength = Math.max(X.length(), Y.length());

            for(int i = 0; i < maxLength; i++){
                if(i < X.length()){
                    String s = String.valueOf(X.charAt(i));
                    if(Xnumbers.containsKey(s)){
                        Xnumbers.put(s, Xnumbers.get(s)+1);
                    }
                    else{
                        Xnumbers.put(s, 1);
                    }
                }
                if(i < Y.length()){
                    String s = String.valueOf(Y.charAt(i));
                    if(Ynumbers.containsKey(s)){
                        Ynumbers.put(s, Ynumbers.get(s)+1);
                    }
                    else{
                        Ynumbers.put(s, 1);
                    }
                }
            }


            for(int i = 9; i >= 0; i--){
                String target = String.valueOf(i);
                if(Xnumbers.containsKey(target) && Ynumbers.containsKey(target)){
                    int minCnt = Math.min(Xnumbers.get(target), Ynumbers.get(target));
                    for(int j = 0; j< minCnt; j++){
                        BigNumber.append(target);
                    }
                }
            }

            if(BigNumber.isEmpty()){
                return "-1";
            }
            if(BigNumber.charAt(0) == '0'){
                return "0";
            }
            return BigNumber.toString();
        }
    }
}
