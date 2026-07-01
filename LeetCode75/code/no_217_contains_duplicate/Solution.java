package no_217_contains_duplicate;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> duplication = new HashSet<>();

        for (int n : nums) {
            if (duplication.contains(n)) return true;
            duplication.add(n);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println(solution.containsDuplicate(nums1)); // true
        System.out.println(solution.containsDuplicate(nums2)); // false
    }
}
