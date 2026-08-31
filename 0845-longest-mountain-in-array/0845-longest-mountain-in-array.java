class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int max = 0;
        int left = 0;

        while(left < n){
            int right = left;

            while(right + 1 < n && arr[right] < arr[right + 1]){
                right++;
            }
            if(right == left){
                left++;
                continue;
            }
            int peak = right;

            while(right + 1 < n && arr[right] > arr[right + 1]){
                right++;
            }
            if(right > peak){
                max = Math.max(max, right - left+1);
            }
            left = Math.max(right, left + 1);
        }
        return max;
    }
}