package no_300_longest_increasing_subsequence;

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxSub = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = 1;
                maxSub = dp[i];
                continue;
            }

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }

            dp[i]++;
            maxSub = Math.max(maxSub, dp[i]);
        }

        return maxSub;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        int result = solution.lengthOfLIS(nums);

        System.out.println("입력 배열: " + Arrays.toString(nums));
        System.out.println("LIS 길이: " + result);
    }
}