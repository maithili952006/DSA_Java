class Solution {
    public int trap(int[] height) {
        int left_Max = 0;
        int right_Max = 0;
        int totalWater = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right){
            if(height[left] < height[right]){
                left_Max = Math.max(left_Max, height[left]);
                totalWater += left_Max - height[left];
                left++;
            }    
            else{
                right_Max = Math.max(right_Max, height[right]);
                totalWater += right_Max - height[right];
                right--;
            }    
        }

        return totalWater;
    }
}