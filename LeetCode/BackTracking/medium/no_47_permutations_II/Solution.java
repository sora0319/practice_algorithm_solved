package medium.no_47_permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 1, 2};

        List<List<Integer>> result = solution.permuteUnique(nums);

        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

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
            if (isUsed[i]) {
                continue;
            }

            // 같은 깊이에서 중복 숫자를 먼저 선택하는 경우를 방지
            if (i > 0 && nums[i - 1] == nums[i] && !isUsed[i - 1]) {
                continue;
            }

            permutation.add(nums[i]);
            isUsed[i] = true;

            backtracking(nums, isUsed, permutation, result);

            permutation.remove(permutation.size() - 1);
            isUsed[i] = false;
        }
    }
}
