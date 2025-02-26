package code;

import java.util.*;

public class GymClothes {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
    }

    private static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int count = 0;
            int[] student = new int[n];

            Arrays.sort(lost);
            Arrays.sort(reserve);

            for(int i = 0; i < reserve.length; i++){
                student[reserve[i]-1] = 1;
            }

            for(int i = 0; i < lost.length; i++){
                student[lost[i]-1]--;
            }

            for(int i = 0; i < lost.length; i++){
                int theif = lost[i]-1;
                if(student[theif] == 0) continue;

                int front = theif - 1;
                int back = theif + 1;

                if(theif > 0 && student[front] == 1){
                    student[front]--;
                    student[theif]++;
                    continue;
                }
                if(theif < n-1 && student[back] == 1){
                    student[back]--;
                    student[theif]++;
                    continue;
                }
            }

            for(int i = 0; i < n; i++){
                if(student[i] >= 0){
                    count++;
                }
            }

            return count;
        }
    }
}
