class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        
        Arrays.sort(arr);
        
        for(int i = 0; i < arr.length; i++){
            if(arr[k - 1] == arr[i]){
                return arr[i];
            }
        }
        return 0;
    }
}
