package no_139_word_break;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] isWord = new boolean[s.length()];

        Set<String> dicts = new HashSet<>(wordDict);

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (i - j > 20) {
                    continue;
                }
                if (j != 0 && !isWord[j - 1]) {
                    continue;
                }

                String word = s.substring(j, i);

                if (dicts.contains(word)) {
                    isWord[i - 1] = true;
                    break;
                }
            }
        }

        return isWord[s.length() - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "leetcode";
        List<String> wordDict1 = Arrays.asList("leet", "code");

        boolean result1 = solution.wordBreak(s1, wordDict1);
        System.out.println(result1); // true

        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");

        boolean result2 = solution.wordBreak(s2, wordDict2);
        System.out.println(result2); // true

        String s3 = "catsandog";
        List<String> wordDict3 =
                Arrays.asList("cats", "dog", "sand", "and", "cat");

        boolean result3 = solution.wordBreak(s3, wordDict3);
        System.out.println(result3); // false
    }
}