public class Keypad {
    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "right"));
    }

    private static class Solution {
        private int right = 12;
        private int left = 10;
        public String solution(int[] numbers, String hand) {
            StringBuilder sb = new StringBuilder();

            for(int i : numbers){
                if(i % 3 == 1){
                    sb.append("L");
                    left = i;
                }
                if(i % 3 == 0 && i != 0){
                    sb.append("R");
                    right = i;
                }
                if(i % 3 == 2 || i == 0){
                    int[] left_position = checkPosition(left);
                    int[] right_position = checkPosition(right);
                    int[] target_position = checkPosition(i);

                    double rDistance = Math.abs(right_position[0] - target_position[0]) + Math.abs(right_position[1] - target_position[1]);
                    double lDistance = Math.abs(left_position[0] - target_position[0]) + Math.abs(left_position[1] - target_position[1]);

                    if(rDistance > lDistance || (rDistance == lDistance  && hand.equals("left"))){
                        sb.append("L");
                        left = i;
                    }
                    if(rDistance < lDistance || (rDistance == lDistance  && hand.equals("right"))){
                        sb.append("R");
                        right = i;
                    }
                }
            }


            return sb.toString();
        }

        private int[] checkPosition(int place){
            int[] position = new int[2];
            if(place == 0){
                position[0] = 3;
                position[1] = 1;
            }
            else if(place % 3 == 0){
                position[0] = place / 3 - 1;
                position[1] = 2;
            }
            else {
                position[0] = place / 3;
                position[1] = place % 3 -1;
            }

            return position;
        }
    }
}
