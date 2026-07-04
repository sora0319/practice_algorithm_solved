package no_128_longest_consecutive_sequence;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            numbers.add(nums[i]);
        }

        int maxCount = 0;

        for (int n : numbers) {
            int starting = n;

            if (numbers.contains(starting - 1)) {
                continue;
            }

            int count = 1;

            while (numbers.contains(starting + 1)) {
                count++;
                starting++;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums1)); // 4

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(solution.longestConsecutive(nums2)); // 9

        int[] nums3 = {7};
        System.out.println(solution.longestConsecutive(nums3)); // 1

        int[] nums4 = {};
        System.out.println(solution.longestConsecutive(nums4)); // 0
    }
}
