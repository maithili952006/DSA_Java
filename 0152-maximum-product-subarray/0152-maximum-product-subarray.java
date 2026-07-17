class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int maxEndHere = nums[0];
        int minEndHere = nums[0];
        int result = nums[0];

        for(int i = 1; i < nums.length;i++){
            int current = nums[i];

            if(current < 0){
                int temp = maxEndHere;
                maxEndHere = minEndHere;
                minEndHere = temp;
            }

            //finding the max and min elements
            maxEndHere = Math.max(current, maxEndHere * current);

            minEndHere = Math.min(current, minEndHere * current);

            result = Math.max(result, maxEndHere);
        } 
        return result;
    }
}