class Solution {

    public boolean possible(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        int bouquets = 0;

        for (int i = 0; i < bloomDay.length; i++) {

            if (bloomDay[i] <= day) {
                count++;
            } else {
                bouquets += count / k;
                count = 0;
            }
        }

        bouquets += count / k;

        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {

        long required = (long) m * k;

        if (required > bloomDay.length) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < bloomDay.length; i++) {
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }

        int low = min;
        int high = max;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (possible(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}