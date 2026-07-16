package no_153_find_minimum_in_rotated_sorted_array;

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;

        while (left < right) {
            if (nums[mid] < nums[right]) {
                right = mid;
                mid = (left + right) / 2;
                continue;
            }
            if (nums[mid] > nums[right]) {
                left = mid + 1;
                mid = (left + right) / 2;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        System.out.println(solution.findMin(nums)); // 0
    }
}