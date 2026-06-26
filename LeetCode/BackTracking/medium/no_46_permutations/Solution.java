package medium.no_46_permutations;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 2, 3};

        List<List<Integer>> result = solution.permute(nums);

        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] isUsed = new boolean[nums.length];
        List<Integer> permutation = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        backtracking(nums, isUsed, permutation, result);

        return result;
    }

    private void backtracking(
            int[] nums,
            boolean[] isUsed,
            List<Integer> permutation,
            List<List<Integer>> result
    ) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!isUsed[i]) {
                permutation.add(nums[i]);
                isUsed[i] = true;

                backtracking(nums, isUsed, permutation, result);

                permutation.remove(permutation.size() - 1);
                isUsed[i] = false;
            }
        }
    }
}
