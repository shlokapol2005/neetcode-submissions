class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int left = 1;
        int right = x;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Use long to prevent integer overflow when mid * mid executes
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1; // Try to find a larger matching integer
            } else {
                right = mid - 1; // Value is too large, search the left half
            }
        }

        return ans;
    }
}