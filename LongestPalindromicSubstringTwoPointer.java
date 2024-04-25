// TC - O(N*N)
// SC - O(1)

public class LongestPalindromicSubstringTwoPointer {
    class Solution {
        private int start;
        private int end;

        public String longestPalindrome(String s) {
            for (int i = 0; i < s.length(); i++) {
                extendAroundCenter(s, i, i); // Odd length palindrom - Mandaory check
                if (i != s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                    extendAroundCenter(s, i, i + 1); // Even length palindrom
                }
            }

            return s.substring(start, end + 1);
        }

        private void extendAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            left++;
            right--;
            if (right - left > end - start) {
                start = left;
                end = right;
            }
        }
    }
}