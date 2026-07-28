package no_424_longest_repeating_character_replacement;

class Solution {
    public int characterReplacement(String s, int k) {
        int[] alphabetCnts = new int[26];
        int start = 0;
        int end = 0;
        int maxLength = 0;
        int maxCharCnt = 0;

        while (end < s.length()) {
            alphabetCnts[s.charAt(end) - 'A']++;

            maxCharCnt = maxCnt(alphabetCnts);

            while (end - start + 1 - maxCharCnt > k) {
                alphabetCnts[s.charAt(start++) - 'A']--;
                maxCharCnt = maxCnt(alphabetCnts);
            }

            maxLength = Math.max(end - start + 1, maxLength);
            end++;
        }

        return maxLength;
    }

    private int maxCnt(int[] alphabetCnts) {
        int maxCharCnt = 0;

        for (int n : alphabetCnts) {
            maxCharCnt = Math.max(maxCharCnt, n);
        }

        return maxCharCnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "ABAB";
        int k1 = 2;
        System.out.println(solution.characterReplacement(s1, k1)); // 4

        String s2 = "AABABBA";
        int k2 = 1;
        System.out.println(solution.characterReplacement(s2, k2)); // 4
    }
}