package medium.no_40_combination_sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> result =
                solution.combinationSum2(candidates, target);

        System.out.println(result);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<Integer> sumCombi = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        backtracking(0, target, candidates, result, sumCombi);

        return result;
    }

    private void backtracking(
            int start,
            int target,
            int[] candidates,
            List<List<Integer>> result,
            List<Integer> sumCombi
    ) {
        if (target == 0) {
            result.add(new ArrayList<>(sumCombi));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i - 1] == candidates[i]) {
                continue;
            }

            if (target - candidates[i] < 0) {
                return;
            }

            sumCombi.add(candidates[i]);

            backtracking(
                    i + 1,
                    target - candidates[i],
                    candidates,
                    result,
                    sumCombi
            );

            sumCombi.remove(sumCombi.size() - 1);
        }
    }
}
