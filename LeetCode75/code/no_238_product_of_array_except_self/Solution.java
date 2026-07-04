package no_238_product_of_array_except_self;

import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        // result[i]에 i의 왼쪽 원소들의 곱 저장
        result[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // 오른쪽 원소들의 곱을 누적하면서 result에 곱하기
        int rightProductNum = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= rightProductNum;
            rightProductNum *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(solution.productExceptSelf(nums1)));
        // [24, 12, 8, 6]

        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(solution.productExceptSelf(nums2)));
        // [0, 0, 9, 0, 0]

        int[] nums3 = {2, 3};
        System.out.println(Arrays.toString(solution.productExceptSelf(nums3)));
        // [3, 2]
    }
}
