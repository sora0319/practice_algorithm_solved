import java.util.Stack;

public class HamburgerMaking {
    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1});
        System.out.println(answer);
    }
    private static class Solution {
        public int solution(int[] ingredient) {
            int hamburger = 0;
            int cnt = 0;
            Stack<Integer> layer = new Stack<>();

            for(int i : ingredient){
                if(hamburger == 3 && i == 1){
                    for(int j = 0; j < 3; j++){
                        layer.pop();
                    }
                    cnt++;
                    if(layer.isEmpty()){
                        hamburger = 0;
                    } else{
                        hamburger = layer.peek();
                    }

                    continue;
                }
                if(i == 1){
                    layer.push(i);
                    hamburger = 1;
                    continue;
                }
                if(layer.isEmpty() && i != 1) continue;
                if(hamburger + 1 != i){
                    layer.clear();
                    hamburger = 0;
                    continue;
                }
                layer.push(i);
                hamburger++;
            }


            return cnt;
        }
    }
}
