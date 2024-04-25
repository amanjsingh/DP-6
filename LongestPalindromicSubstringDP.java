// TC - O(N*N)
// SC - O(N*N)

public class LongestPalindromicSubstringDP {
    class Solution {
        private int start;
        private int end;

        public String longestPalindrome(String s) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = i; j >= 0; j--) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (i - j < 2 || dp[i - 1][j + 1]) {
                            dp[i][j] = true;
                        }
                    } else {
                        dp[i][j] = false;
                    }

                    if (dp[i][j] && i - j > end - start) {
                        start = j;
                        end = i;
                    }
                }
            }

            return s.substring(start, end + 1);
        }
    }
}
