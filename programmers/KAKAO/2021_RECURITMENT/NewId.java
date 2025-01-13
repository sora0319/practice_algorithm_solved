public class NewId {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("...!@BaT#*..y.abcdefghijklm"));
    }
    private static class Solution {
        public String solution(String new_id) {
            StringBuilder sb = new StringBuilder();
            String answer = "";

            new_id = new_id.toLowerCase();

            char prevChar = new_id.charAt(0);
            for(int i = 0; i < new_id.length(); i++){
                if(prevChar == '.' && prevChar == new_id.charAt(i)) continue;
                if(new_id.charAt(i) >= 'a' && new_id.charAt(i) <= 'z') {
                    sb.append(new_id.charAt(i));
                    prevChar = new_id.charAt(i);
                    continue;
                }

                if(new_id.charAt(i) >= '0' && new_id.charAt(i) <= '9'){
                    sb.append(new_id.charAt(i));
                    prevChar = new_id.charAt(i);
                    continue;
                }

                if(new_id.charAt(i) == '-' || new_id.charAt(i) == '_' || new_id.charAt(i) == '.'){
                    sb.append(new_id.charAt(i));
                    prevChar = new_id.charAt(i);
                    continue;
                }


            }

            if(sb.length() != 0 && sb.substring(0,1).equals(".")) sb.deleteCharAt(0);
            if(sb.length() != 0 && sb.substring(sb.length()-1, sb.length()).equals(".")) sb.deleteCharAt(sb.length()-1);

            if(sb.length() == 0) sb.append("a");

            if(sb.length() >= 16){
                if(sb.substring(14,15).equals(".")){
                    answer = sb.substring(0,14);
                }
                else{
                    answer = sb.substring(0,15);
                }
            }

            if(sb.length() <= 2){
                String lastChar = sb.substring(sb.length()-1, sb.length());
                while(sb.length() < 3){
                    sb.append(lastChar);
                }
                answer = sb.toString();
            }

            if(answer.length() == 0) answer = sb.toString();

            return answer;
        }
    }
}
