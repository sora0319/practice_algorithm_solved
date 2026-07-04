package no_125_valid_palindrome;

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                continue;
            }

            sb.append(Character.toLowerCase(c));
        }

        String original = sb.toString();
        String reversed = sb.reverse().toString();

        if (original.equals(reversed)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        // true

        System.out.println(solution.isPalindrome("race a car"));
        // false

        System.out.println(solution.isPalindrome("0P"));
        // false

        System.out.println(solution.isPalindrome(" "));
        // true
    }
}