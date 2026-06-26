package medium.no_39_combination_sum;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result =
                solution.combinationSum(candidates, target);

        System.out.println(result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> sumCombi = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        makingCombination(0, target, 0, candidates, sumCombi, result);

        return result;
    }

    private void makingCombination(
            int sum,
            int target,
            int start,
            int[] candidates,
            List<Integer> sumCombi,
            List<List<Integer>> result
    ) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            result.add(new ArrayList<>(sumCombi));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            sumCombi.add(candidates[i]);

            makingCombination(
                    sum + candidates[i],
                    target,
                    i,
                    candidates,
                    sumCombi,
                    result
            );

            sumCombi.remove(sumCombi.size() - 1);
        }
    }
}
