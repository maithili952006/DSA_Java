class Solution {
    public int longestSubarrayDivK(int[] arr, int k) {
        // code here
        HashMap<Long, Integer> map = new HashMap<>();

        long prefixSum = 0;
        int maxLength = 0;

        map.put(0L, -1);

        for (int i = 0; i < arr.length; i++) {

            prefixSum += arr[i];

            long remainder = prefixSum % k;

            if (remainder < 0) {
                remainder += k;
            }

            if (map.containsKey(remainder)) {

                int length = i - map.get(remainder);

                maxLength = Math.max(maxLength, length);

            } else {

                map.put(remainder, i);
            }
        }

        return maxLength;
    }
}
