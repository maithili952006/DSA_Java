class Solution {
    public int myAtoi(String s) {
        s = s.trim(); // 1. Remove outer spaces
        if (s.isEmpty()) return 0;

        int i = 0, sign = 1;
        long num = 0; // 64-bit long to avoid overflow math

        // 2. Check sign
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            sign = (s.charAt(0) == '-') ? -1 : 1;
            i++;
        }

        // 3. Convert numbers
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            num = num * 10 + (s.charAt(i) - '0');
            i++;

            // 4. Cap if out of limits
            if (sign * num >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * num <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int) (sign * num);
    }
}