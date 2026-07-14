package no_53_maximum_subarray;

class Solution {
    public int maxSubArray(int[] nums) {
        int maxValue = nums[0];
        int sums = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < sums + nums[i]) {
                sums += nums[i];
            } else if (nums[i] >= sums + nums[i]) {
                sums = nums[i];
            }

            maxValue = Math.max(maxValue, sums);
        }

        return maxValue;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {1};
        int[] nums3 = {5, 4, -1, 7, 8};
        int[] nums4 = {1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4};

        System.out.println(solution.maxSubArray(nums1)); // 6
        System.out.println(solution.maxSubArray(nums2)); // 1
        System.out.println(solution.maxSubArray(nums3)); // 23
        System.out.println(solution.maxSubArray(nums4)); // 6
    }
}