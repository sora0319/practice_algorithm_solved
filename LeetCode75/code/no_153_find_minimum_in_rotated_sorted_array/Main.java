package no_153_find_minimum_in_rotated_sorted_array;

import java.util.Arrays;

public class Main {

    static class Solution {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] < nums[right]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return nums[left];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        System.out.println("배열: " + Arrays.toString(nums));
        System.out.println("최솟값: " + solution.findMin(nums));
    }
}