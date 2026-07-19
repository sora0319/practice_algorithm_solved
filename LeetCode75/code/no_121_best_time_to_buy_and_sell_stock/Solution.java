package no_121_best_time_to_buy_and_sell_stock;

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyStock = prices[0];

        for (int p : prices) {
            if (buyStock >= p) {
                buyStock = p;
                continue;
            }

            profit = Math.max(profit, p - buyStock);
        }

        return profit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] prices = {7, 1, 5, 3, 6, 4};

        int result = solution.maxProfit(prices);
        System.out.println("Max Profit: " + result); // 5
    }
}