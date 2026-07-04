package no_242_valid_anagram;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();

        if (s.length() != t.length()) return false;

        for (char c : s.toCharArray()) {
            if (!count.containsKey(c)) {
                count.put(c, 0);
            }

            count.put(c, count.get(c) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!count.containsKey(c)) return false;
            if (count.get(c) == 0) return false;

            count.put(c, count.get(c) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isAnagram("anagram", "nagaram")); // true
        System.out.println(solution.isAnagram("rat", "car"));         // false
        System.out.println(solution.isAnagram("a", "a"));             // true
        System.out.println(solution.isAnagram("ab", "aa"));           // false
    }
}
