package no_70_climbing_stairs;

class Solution {
    public int climbStairs(int n) {
        int[] count = new int[n + 1];
        count[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (i == 2) {
                count[i] = 2;
                continue;
            }

            count[i] = count[i - 1] + count[i - 2];
        }

        return count[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.climbStairs(1)); // 1
        System.out.println(solution.climbStairs(2)); // 2
        System.out.println(solution.climbStairs(3)); // 3
        System.out.println(solution.climbStairs(4)); // 5
        System.out.println(solution.climbStairs(5)); // 8
    }
}
