package no_11_container_with_most_water;

class Solution {

    public int maxArea(int[] height) {
        int max = 0;
        int right = height.length - 1;
        int left = 0;

        while (left != right) {
            int x = right - left;
            int y;

            if (height[right] > height[left]) {
                y = height[left];
                left++;
            } else {
                y = height[right];
                right--;
            }

            max = Math.max(max, x * y);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(height1)); // 49

        int[] height2 = {1, 1};
        System.out.println(solution.maxArea(height2)); // 1

        int[] height3 = {4, 3, 2, 1, 4};
        System.out.println(solution.maxArea(height3)); // 16

        int[] height4 = {1, 2, 1};
        System.out.println(solution.maxArea(height4)); // 2
    }
}