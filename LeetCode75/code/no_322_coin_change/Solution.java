package no_322_coin_change;

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] counts = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            counts[i] = -1;
        }

        for (int i = 1; i <= amount; i++) {
            int count = Integer.MAX_VALUE;

            for (int c : coins) {
                if (c > i) break;

                int j = i - c;

                if (counts[j] == -1) continue;

                count = Math.min(count, counts[j] + 1);
            }

            if (count != Integer.MAX_VALUE) {
                counts[i] = count;
            }
        }

        return counts[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] coins = {1, 2, 5};
        int amount = 11;

        int result = solution.coinChange(coins, amount);

        System.out.println("Minimum coins: " + result); // 3
    }
}