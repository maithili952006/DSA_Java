class Solution {
    public void reverseArray(int arr[]) {
        // code here
        int left = 0; 
        int right = arr.length - 1;
        
        for(int i = 0; i < arr.length; i++){
            while(left < right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                
                left ++;
                right--;
            }
        }
    }
}