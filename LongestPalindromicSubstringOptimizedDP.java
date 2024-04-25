// TC - O(N*N)
// SC - O(N)

public class LongestPalindromicSubstringOptimizedDP {
    class Solution {
        private int start;
        private int end;

        public String longestPalindrome(String s) {
            int n = s.length();
            boolean[] dp = new boolean[n];
            for (int i = 0; i < n; i++) {
                boolean isEnclosedStringPalindrom = false;
                for (int j = i; j >= 0; j--) {
                    boolean temp = dp[j];
                    if (s.charAt(i) == s.charAt(j)) {
                        if (i - j < 2 || isEnclosedStringPalindrom) {
                            dp[j] = true;
                        } else {
                            dp[j] = false; // To rewrite true from above row
                        }
                    } else {
                        dp[j] = false; // To rewrite true from above row
                    }

                    if (dp[j] && i - j > end - start) {
                        start = j;
                        end = i;
                    }

                    isEnclosedStringPalindrom = temp;
                }
            }

            return s.substring(start, end + 1);
        }
    }
}
