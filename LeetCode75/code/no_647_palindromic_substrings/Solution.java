package no_647_palindromic_substrings;

class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // 홀수 길이 팰린드롬
            count += counting(i, i, s);

            // 짝수 길이 팰린드롬
            count += counting(i, i + 1, s);
        }

        return count;
    }

    private int counting(int left, int right, String s) {
        int count = 0;

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }

            count++;
            left--;
            right++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "abc";
        String s2 = "aaa";
        String s3 = "abba";

        System.out.println(solution.countSubstrings(s1)); // 3
        System.out.println(solution.countSubstrings(s2)); // 6
        System.out.println(solution.countSubstrings(s3)); // 6
    }
}