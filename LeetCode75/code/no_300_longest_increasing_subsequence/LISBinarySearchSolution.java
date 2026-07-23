package no_300_longest_increasing_subsequence;

import java.util.Arrays;

class LISBinarySearchSolution {

    public int lengthOfLIS(int[] nums) {
        int[] lastValue = new int[nums.length];
        int longSub = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                lastValue[i] = nums[i];
                longSub = 1;
                continue;
            }

            int result = Arrays.binarySearch(
                    lastValue,
                    0,
                    longSub,
                    nums[i]
            );

            if (result < 0) {
                int insertIndex = -(result + 1);

                lastValue[insertIndex] = nums[i];
                longSub = Math.max(insertIndex + 1, longSub);
            }
        }

        return longSub;
    }

    public static void main(String[] args) {
        LISBinarySearchSolution solution =
                new LISBinarySearchSolution();

        int[] nums = {
                10, 9, 2, 5, 3, 7, 101, 18
        };

        int result = solution.lengthOfLIS(nums);

        System.out.println(
                "입력 배열: " + Arrays.toString(nums)
        );
        System.out.println("LIS 길이: " + result);
    }
}