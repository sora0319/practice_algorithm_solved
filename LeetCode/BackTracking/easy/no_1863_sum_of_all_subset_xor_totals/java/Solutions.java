package no_1863_sum_of_all_subset_xor_totals.java;

class Solutions {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {1, 3};

        int result = sol.subsetXORSum(nums);

        System.out.println("result = " + result);
    }

    static class Solution {
        public int subsetXORSum(int[] nums) {

            return calculate(0, 0, nums);
        }

        private int calculate(int order, int cal, int[] nums){
            int result = 0;
            if(order == nums.length){
                return 0;
            }

            for(int i = order; i < nums.length; i++){
                cal = cal ^ nums[i];
                result += cal;
                result += calculate(i+1, cal, nums);
                cal = cal ^ nums[i];
            }

            return result;
        }
    }
}