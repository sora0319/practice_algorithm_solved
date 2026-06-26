package medium.no_17_letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String digits = "23";

        List<String> answer = solution.letterCombinations(digits);

        System.out.println(answer);
    }

    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        StringBuilder sb = new StringBuilder();

        makingLetterCombi(digits, 0, sb);

        return result;
    }

    private void makingLetterCombi(String digits, int start, StringBuilder sb) {
        if (digits.length() == start) {
            result.add(sb.toString());
            return;
        }

        int num = digits.charAt(start) - '0';

        int startingChar = (num - 2) * 3 + 97;

        if (num == 8 || num == 9) {
            startingChar++;
        }

        int range = startingChar + 3;

        if (num == 7 || num == 9) {
            range++;
        }

        for (int i = startingChar; i < range; i++) {
            sb.append((char) i);
            makingLetterCombi(digits, start + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
