public class ThreeMusketeers {
    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution(new int[]{-3, -2, -1, 0, 1, 2, 3});
        System.out.println(answer);
    }
    private static class Solution {
        public int solution(int[] number) {
            int result = 0;

            for(int i = 0; i < number.length; i++){
                for(int j = i+1; j < number.length; j++){
                    for(int z = j+1; z < number.length; z++){
                        if(number[i] + number[j] + number[z] == 0) result++;
                    }
                }
            }


            return result;
        }
    }
}
