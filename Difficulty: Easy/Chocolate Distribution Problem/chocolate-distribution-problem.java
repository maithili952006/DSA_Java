class Solution {
    public int findMinDiff(int arr[], int m) {
        // code here
         int n = arr.length;
        
        Arrays.sort(arr);
        
        int minDiff = Integer.MAX_VALUE;
        
        for(int i= 0;i + m - 1 < n;i++){
            int diff = arr[i + m - 1] - arr[i];
            
            if(diff < minDiff){
                minDiff = diff;
            }
        }
         return minDiff;
    }
}