package no_1_two_sum;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        backtrack(0, 0, result, nums, target);

        return result;
    }

    private void backtrack(int start, int element, int[] result, int[] nums, int target) {
        if (element == 2) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (result[0] != result[1] && nums[result[0]] + nums[result[1]] == target) {
                break;
            }

            result[element] = i;
            backtrack(i + 1, element + 1, result, nums, target);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = solution.twoSum(nums, target);

        System.out.println("결과 인덱스: [" + result[0] + ", " + result[1] + "]");
        System.out.println("값: " + nums[result[0]] + " + " + nums[result[1]]
                + " = " + target);
    }
}
