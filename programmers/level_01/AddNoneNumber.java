public class AddNoneNumber {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1,2,3,4,6,7,8,0}));
    }
    private static class Solution {
        public int solution(int[] numbers) {
            int total = 45;

            for(int i : numbers){
                total -= i;
            }
            return total;
        }
    }
}
