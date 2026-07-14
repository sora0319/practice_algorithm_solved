package no_91_decode_ways;

class Solution {
    public int numDecodings(String s) {
        int[] decodedCount = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                if (i == 0) {
                    decodedCount[i] = 1;
                    continue;
                }

                decodedCount[i] += decodedCount[i - 1];
            }

            if (i > 0) {
                int n = Integer.parseInt(
                    "" + s.charAt(i - 1) + s.charAt(i)
                );

                if (10 <= n && n <= 26) {
                    if (i == 1) {
                        decodedCount[i]++;
                        continue;
                    }

                    decodedCount[i] += decodedCount[i - 2];
                }
            }
        }

        return decodedCount[s.length() - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "12";
        String s2 = "226";
        String s3 = "06";
        String s4 = "106";

        System.out.println(solution.numDecodings(s1)); // 2
        System.out.println(solution.numDecodings(s2)); // 3
        System.out.println(solution.numDecodings(s3)); // 0
        System.out.println(solution.numDecodings(s4)); // 1
    }
}