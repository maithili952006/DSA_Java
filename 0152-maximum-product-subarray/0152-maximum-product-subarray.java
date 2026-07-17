class Solution {
    public int maxProduct(int[] nums) {
        
        if(nums == null || nums.length == 0){
            return 0;
        }

        int maxEle = nums[0];
        int minEle = nums[0];
        int result = nums[0];

        for(int i = 1; i < nums.length;i++){
            int current = nums[i];

            if(current < 0){
                int temp = maxEle;
                maxEle = minEle;
                minEle = temp;
            }

            maxEle = Math.max(current, maxEle * current);
            minEle = Math.min(current,minEle * current);

            result = Math.max(result, maxEle);
        }
        return result;
    }
}