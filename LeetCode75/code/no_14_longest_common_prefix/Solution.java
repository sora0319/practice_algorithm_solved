package no_14_longest_common_prefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int wordLength = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
            int minWordLength = 0;

            for (int j = 0; j < strs[0].length(); j++) {
                if (j >= strs[i].length()) {
                    break;
                }
                if (strs[0].charAt(j) != strs[i].charAt(j)) {
                    break;
                }

                minWordLength++;
            }

            wordLength = Math.min(wordLength, minWordLength);
        }

        return strs[0].substring(0, wordLength);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strs = {"flower", "flow", "flight"};

        String result = solution.longestCommonPrefix(strs);

        System.out.println(result); // fl
    }
}