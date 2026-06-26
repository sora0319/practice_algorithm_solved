package medium.no_22_generate_parentheses;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 3;

        List<String> result = solution.generateParenthesis(n);

        System.out.println("n = " + n);
        System.out.println(result);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        makingParenthesis(n, n, sb, result);

        return result;
    }

    private void makingParenthesis(
            int open,
            int close,
            StringBuilder sb,
            List<String> result
    ) {
        // 열린 괄호와 닫힌 괄호를 모두 사용한 경우
        if (open == 0 && close == 0) {
            result.add(sb.toString());
            return;
        }

        // '(' 를 추가할 수 있는 경우
        if (open > 0) {
            sb.append('(');

            makingParenthesis(open - 1, close, sb, result);

            sb.deleteCharAt(sb.length() - 1);
        }

        // ')' 를 추가할 수 있는 경우
        // 남은 close가 open보다 많다는 것은
        // 현재까지 '('가 ')'보다 더 많이 사용되었다는 뜻
        if (open < close) {
            sb.append(')');

            makingParenthesis(open, close - 1, sb, result);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
