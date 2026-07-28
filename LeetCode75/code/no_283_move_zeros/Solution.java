package no_283_move_zeros;

import java.util.Arrays;

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 1;

        while (right < n && left < n) {
            if (nums[left] != 0) {
                left++;
                continue;
            }

            right = left + 1;

            while (right < n && nums[right] == 0) {
                right++;
            }

            if (right >= n) {
                break;
            }

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {0, 1, 0, 3, 12};

        solution.moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }
}