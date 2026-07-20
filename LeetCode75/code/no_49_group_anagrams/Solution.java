package no_49_group_anagrams;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> place = new HashMap<>();

        for (String s : strs) {
            char[] comparedLetter = s.toCharArray();
            Arrays.sort(comparedLetter);
            String sortedStr = String.valueOf(comparedLetter);

            if (!place.containsKey(sortedStr)) {
                result.add(new ArrayList<>(Arrays.asList(s)));
                place.put(sortedStr, result.size() - 1);
                continue;
            }

            List<String> saved = result.get(place.get(sortedStr));
            saved.add(s);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = solution.groupAnagrams(strs);

        System.out.println(result);
    }
}