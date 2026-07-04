package no_191_number_of_1_bits;

class Solution {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.hammingWeight(11)); // 3
        // 11의 이진수: 1011

        System.out.println(solution.hammingWeight(128)); // 1
        // 128의 이진수: 10000000

        System.out.println(solution.hammingWeight(-3)); // 31
        // Java int는 32비트 signed 정수라서 음수도 비트 기준으로 계산됨
    }
}