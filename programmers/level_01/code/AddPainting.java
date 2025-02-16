package code;

public class AddPainting {
    public static void main(String[] args) {
        Solution S = new Solution();
        int answer = S.solution(8,4,new int[]{2,3,6});
        System.out.println(answer);
    }
    private static class Solution {
        public int solution(int n, int m, int[] section) {
            int answer = 0;
            int color = 0;
            int i = 0;

            while(i < section.length){
                if(color >= section[i]){
                    i++;
                    continue;
                }
                color = section[i] + m - 1;
                answer++;
                i++;
            }

            return answer;
        }
    }
}
