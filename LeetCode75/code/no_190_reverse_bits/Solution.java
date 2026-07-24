package no_190_reverse_bits;

class Solution {

    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 43261596;
        int result = solution.reverseBits(n);

        System.out.println(result);
    }
}