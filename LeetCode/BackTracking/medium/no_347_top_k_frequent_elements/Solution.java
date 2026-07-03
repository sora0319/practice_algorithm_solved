package medium.no_347_top_k_frequent_elements;

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counting = new HashMap<>();

        for (int n : nums) {
            if (!counting.containsKey(n)) {
                counting.put(n, 0);
            }
            counting.put(n, counting.get(n) + 1);
        }

        List<Map.Entry<Integer, Integer>> countingList =
                new ArrayList<>(counting.entrySet());

        countingList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = countingList.get(i);
            result[i] = entry.getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] result = solution.topKFrequent(nums, k);

        System.out.println(Arrays.toString(result));
    }
}
