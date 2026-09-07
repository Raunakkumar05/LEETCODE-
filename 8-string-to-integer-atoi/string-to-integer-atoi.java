class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;

        // Step 1: Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Determine the sign
        boolean negative = false;

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            negative = s.charAt(i) == '-';
            i++;
        }

        // Step 3: Convert digits
        int result = 0;
        int limit = negative ? Integer.MIN_VALUE : -Integer.MAX_VALUE;
        int limitBeforeLastDigit = limit / 10;

        while (i < n) {
            char ch = s.charAt(i);

            if (ch < '0' || ch > '9') {
                break;
            }

            int digit = ch - '0';

            // Check for overflow before multiplying by 10
            if (result < limitBeforeLastDigit ||
                (result == limitBeforeLastDigit && digit > -(limit % 10))) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result * 10 - digit;
            i++;
        }

        return negative ? result : -result;
    }
}