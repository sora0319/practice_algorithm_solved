package no_15_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, List<Integer>> count = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (!count.containsKey(nums[i])) {
                count.put(nums[i], new ArrayList<>());
            }

            List<Integer> position = count.get(nums[i]);
            position.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int gap = 0 - nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int target = gap - nums[j];

                if (count.containsKey(target)) {
                    for (int t : count.get(target)) {
                        if (t > j) {
                            List<Integer> triplet = List.of(nums[i], nums[j], target);
                            result.add(triplet);
                            break;
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums1));
        // [[-1, -1, 2], [-1, 0, 1]]

        int[] nums2 = {0, 1, 1};
        System.out.println(solution.threeSum(nums2));
        // []

        int[] nums3 = {0, 0, 0};
        System.out.println(solution.threeSum(nums3));
        // [[0, 0, 0]]

        int[] nums4 = {0, 0, 0, 0};
        System.out.println(solution.threeSum(nums4));
        // [[0, 0, 0]]
    }
}